package com.globallogic.prueba.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.prueba.model.User;
import com.globallogic.prueba.model.request.LoginRq;
import com.globallogic.prueba.model.response.UserRs;
import com.globallogic.prueba.repositories.UserRepository;
import com.globallogic.prueba.security.JWTAuthtenticationConfig;
import com.globallogic.prueba.util.formater.Formater;
import com.globallogic.prueba.util.formater.UserLoginFormater;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	JWTAuthtenticationConfig jwtAuthtenticationConfig;

	@Override
	public UserRs getUserLogin(LoginRq loginRq) {

		try {
			UUID uId = UUID.fromString(loginRq.getId().toString());
			User user = userRepo.findById(uId).orElse(null);
			if (user != null) {
				LocalDateTime myDate = LocalDateTime.now();
				String token = jwtAuthtenticationConfig.getJWTToken(user.getEmail() + myDate.toString());

				user.setToken(token);
				user.setLastLogin(myDate);
				userRepo.save(user);

				Formater<User> formater = new UserLoginFormater();
				return (UserRs) formater.format(user);
			}
		} catch (Exception e) {
			// TODO: log
		}

		return null;
	}
}
