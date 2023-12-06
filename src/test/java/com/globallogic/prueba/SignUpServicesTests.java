package com.globallogic.prueba;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import com.globallogic.prueba.model.request.PhoneRq;
import com.globallogic.prueba.model.request.UserRq;
import com.globallogic.prueba.model.response.MessageRs;
import com.globallogic.prueba.repositories.UserRepository;
import com.globallogic.prueba.services.SignUpServiceImpl;

//@WebMvcTest(value = SignUpServices.class)
@ExtendWith(MockitoExtension.class)
public class SignUpServicesTests {

	//@Autowired
	//private MockMvc mockMvc;

	@InjectMocks
	private SignUpServiceImpl signUpService;

	 @Mock
	 private UserRepository userRepo;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@Order(1)
	@DisplayName("Testing Service Email No OK: email invalido")
	public void createUserEmailNOOK() throws Exception {
		MessageRs userRs = new MessageRs();
		UserRq mockUser = new UserRq();

		userRs.setDetail("Email con formato invalido");
		userRs.setCodigo(HttpStatus.BAD_REQUEST.value());

		mockUser.setName("Nestor");
		mockUser.setPassword("pwd");
		mockUser.setEmail("nj05don.com");

		Set<PhoneRq> setPhone = new HashSet<PhoneRq>();
		PhoneRq phone = new PhoneRq();
		phone.setNumber("757899111");
		phone.setCitycode("12");
		phone.setContrycode("52");
		phone.setUserRq(null);
		setPhone.add(phone);

		mockUser.setPhone(setPhone);
		MessageRs msgRs = signUpService.createUser(mockUser);

		assertThat(msgRs).isNotNull();
		assertEquals(msgRs.getDetail(), userRs.getDetail());

	}
	
	@Test
	@Order(2)
    @DisplayName("Testing Service Password No OK: pwd invalido")
	public void createUserPasswordNOOK() throws Exception {
		MessageRs userRs = new MessageRs();
		UserRq mockUser = new UserRq();

		userRs.setDetail("Password con formato invalido");
		userRs.setCodigo(HttpStatus.BAD_REQUEST.value());

		mockUser.setName("Nestor");
		mockUser.setPassword("pwd");
		mockUser.setEmail("nj0588@gmail.com");

		Set<PhoneRq> setPhone = new HashSet<PhoneRq>();
		PhoneRq phone = new PhoneRq();
		phone.setNumber("757899111");
		phone.setCitycode("12");
		phone.setContrycode("52");
		phone.setUserRq(null);
		setPhone.add(phone);

		mockUser.setPhone(setPhone);
		MessageRs msgRs = signUpService.createUser(mockUser);

		assertThat(msgRs).isNotNull();
		assertEquals(msgRs.getDetail(), userRs.getDetail());
	}
	
	@Test
	@Order(3)
    @DisplayName("Testing Service usuario OK: usuario creado OK")
	public void createUserOK() throws Exception {
		MessageRs userRs = new MessageRs();
		UserRq mockUser = new UserRq();

		//userRs.setDetail("OK");
		userRs.setCodigo(HttpStatus.CREATED.value());

		mockUser.setName("Nestor");
		mockUser.setPassword("pwcvmklM13");
		mockUser.setEmail("nj0588@gmail.com");

		Set<PhoneRq> setPhone = new HashSet<PhoneRq>();
		PhoneRq phone = new PhoneRq();
		phone.setNumber("757899111");
		phone.setCitycode("12");
		phone.setContrycode("52");
		phone.setUserRq(null);
		setPhone.add(phone);

		mockUser.setPhone(setPhone);
		MessageRs msgRs = signUpService.createUser(mockUser);

		assertThat(msgRs).isNotNull();
		assertEquals(msgRs.getCodigo(), userRs.getCodigo());
	}

}
