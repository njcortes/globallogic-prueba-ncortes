package com.globallogic.prueba.services;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.globallogic.prueba.model.Phone;
import com.globallogic.prueba.model.User;
import com.globallogic.prueba.model.request.PhoneRq;
import com.globallogic.prueba.model.request.UserRq;
import com.globallogic.prueba.model.response.MessageRs;
import com.globallogic.prueba.model.response.UserRs;
import com.globallogic.prueba.model.response.UserSignUpRs;
import com.globallogic.prueba.repositories.PhoneRepository;
import com.globallogic.prueba.repositories.UserRepository;
import com.globallogic.prueba.security.JWTAuthtenticationConfig;
import com.globallogic.prueba.util.formater.Formater;
import com.globallogic.prueba.util.formater.UserLoginFormater;
import com.globallogic.prueba.util.formater.UserSignUpFormater;
import com.globallogic.prueba.util.validator.EmailValidator;
import com.globallogic.prueba.util.validator.PasswordValidator;
import com.globallogic.prueba.util.validator.UserValidator;
import com.globallogic.prueba.util.validator.Validator;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PhoneRepository phoneRepo;

	@Autowired
	JWTAuthtenticationConfig jwtAuthtenticationConfig;

	@Override
	public MessageRs createUser(UserRq userRq) {
		User user = new User();
		MessageRs userRs = new MessageRs();
		LocalDateTime myDate = LocalDateTime.now();
		try {
			userRs.setTimestamp(myDate);
			Validator uValidator = new UserValidator(userRepo);
			if (uValidator.validate(userRq.getEmail())) {
				userRs.setDetail("Email ya existe");
				userRs.setCodigo(HttpStatus.BAD_REQUEST.value());
				return userRs;
			}

			Validator eValidator = new EmailValidator();
			if (!eValidator.validate(userRq.getEmail())) {
				userRs.setDetail("Email con formato invalido");
				userRs.setCodigo(HttpStatus.BAD_REQUEST.value());
				return userRs;
			}

			Validator pValidator = new PasswordValidator();
			if (!pValidator.validate(userRq.getPassword())) {
				userRs.setDetail("Password con formato invalido");
				userRs.setCodigo(HttpStatus.BAD_REQUEST.value());
				return userRs;
			}
			
			UUID userUuid = UUID.nameUUIDFromBytes(userRq.getEmail().getBytes());
			String token = jwtAuthtenticationConfig.getJWTToken(userRq.getEmail() + myDate.toString());
			
			user.setId(userUuid);
			user.setName(userRq.getName());
			user.setPassword(userRq.getPassword());
			user.setEmail(userRq.getEmail());
			user.setCreated(myDate);
			user.setToken(token);
			user.setIsActive(true);
			user = userRepo.save(user);
			
			if (userRq.getPhone() != null) {
				HashSet<Phone> hsPhone = new HashSet<Phone>();
				for (PhoneRq phoneRq : userRq.getPhone()) {
					Phone phone = new Phone();
					phone.setNumber(phoneRq.getNumber());
					phone.setCitycode(phoneRq.getCitycode());
					phone.setContrycode(phoneRq.getContrycode());
					phone.setUser(user);

					hsPhone.add(phone);
				}
				phoneRepo.saveAll(hsPhone);

				user.setPhone(hsPhone);
			}
			userRs.setDetail(user.getId().toString());
			userRs.setCodigo(HttpStatus.CREATED.value());
		} catch (Exception e) {
			userRs.setDetail("Exception");
			userRs.setCodigo(HttpStatus.BAD_REQUEST.value());
			//TODO: log
		}

		return userRs;
	}

	@Override
	public UserSignUpRs getUserSignUp(String userId) {
		try {
			UUID uId = UUID.fromString(userId);
			User user = userRepo.findById(uId).orElse(null);
			if (user != null) {
				Formater<User> formater = new UserSignUpFormater();
				return (UserSignUpRs) formater.format(user);
			}
		} catch (Exception e) {
			//TODO: log
		}
		
		return null;
	}

	@Override
	public UserRs getUserLogin(String userId) {

		try {
			UUID uId = UUID.fromString(userId);
			User user = userRepo.findById(uId).orElse(null);
			if (user != null) {
				LocalDateTime myDate = LocalDateTime.now();
				user.setLastLogin(myDate);
				userRepo.save(user);

				Formater<User> formater = new UserLoginFormater();
				return (UserRs) formater.format(user);
			}
		} catch (Exception e) {
			//TODO: log
		}

		return null;
	}

	@Override
	public UserRs getUser(String userId) {
		try {
			UUID uId = UUID.fromString(userId);
			User user = userRepo.findById(uId).orElse(null);
			if (user != null) {
				Formater<User> formater = new UserLoginFormater();
				return (UserRs) formater.format(user);
			}
		} catch (Exception e) {
			//TODO: log
		}
		
		return null;
	}

}
