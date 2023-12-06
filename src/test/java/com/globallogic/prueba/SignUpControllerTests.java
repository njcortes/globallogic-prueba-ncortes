package com.globallogic.prueba;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.globallogic.prueba.controller.SignUpController;
import com.globallogic.prueba.model.request.PhoneRq;
import com.globallogic.prueba.model.request.UserRq;
import com.globallogic.prueba.model.response.MessageRs;
import com.globallogic.prueba.services.SignUpServiceImpl;


@WebMvcTest(value = SignUpController.class)
@TestInstance(Lifecycle.PER_CLASS)
public class SignUpControllerTests {


	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SignUpServiceImpl userService;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@BeforeAll
	public void setup()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	@Order(1)
    @DisplayName("Testing Email No OK: email invalido")
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
		phone.setNumber("98748112233");
		phone.setCitycode("9");
		phone.setContrycode("56");
		setPhone.add(phone);

		mockUser.setPhone(setPhone);

		String myJSON = "{\n" + "    \"name\": \"nestor\",\n" + "    \"email\": \"nj05don.com\",\n"
				+ "    \"password\": \"pwd\",\n" + "    \"phone\": [\n" + "        {\n"
				+ "            \"number\": \"987483212\",\n" + "            \"citycode\": \"32\",\n"
				+ "            \"contrycode\": \"56\"\n" + "        }\n" + "    ]\n" + "}";

		Mockito.when(userService.createUser(Mockito.any(UserRq.class))).thenReturn(userRs);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/sign-up").accept(MediaType.APPLICATION_JSON)
				.content(myJSON).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
	}
	
	@Test
	@Order(2)
    @DisplayName("Testing Password No OK: pwd invalido")
	public void createUserPasswordNOOK() throws Exception {
		MessageRs userRs = new MessageRs();
		UserRq mockUser = new UserRq();

		userRs.setDetail("Password con formato invalido");
		userRs.setCodigo(HttpStatus.BAD_REQUEST.value());
		
		mockUser.setName("Nestor");
		mockUser.setPassword("pwd");
		mockUser.setEmail("nj05@domain.com");

		Set<PhoneRq> setPhone = new HashSet<PhoneRq>();
		PhoneRq phone = new PhoneRq();
		phone.setNumber("98748112233");
		phone.setCitycode("9");
		phone.setContrycode("56");
		setPhone.add(phone);

		mockUser.setPhone(setPhone);

		String myJSON = "{\n" + "    \"name\": \"nestor\",\n" + "    \"email\": \"nj05@domain.com\",\n"
				+ "    \"password\": \"pwd\",\n" + "    \"phone\": [\n" + "        {\n"
				+ "            \"number\": \"987483212\",\n" + "            \"citycode\": \"32\",\n"
				+ "            \"contrycode\": \"56\"\n" + "        }\n" + "    ]\n" + "}";

		Mockito.when(userService.createUser(Mockito.any(UserRq.class))).thenReturn(userRs);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/sign-up").accept(MediaType.APPLICATION_JSON)
				.content(myJSON).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
	}
	
	@Test
	@Order(3)
    @DisplayName("Testing usuario OK: usuario creado OK")
	public void createUserOK() throws Exception {
		MessageRs userRs = new MessageRs();
		UserRq mockUser = new UserRq();

		userRs.setCodigo(HttpStatus.CREATED.value());

		mockUser.setName("Nestor");
		mockUser.setPassword("pwd3J5fghj");
		mockUser.setEmail("nj05@domain.com");

		Set<PhoneRq> setPhone = new HashSet<PhoneRq>();
		PhoneRq phone = new PhoneRq();
		phone.setNumber("98748112233");
		phone.setCitycode("9");
		phone.setContrycode("56");
		setPhone.add(phone);

		mockUser.setPhone(setPhone);

		String myJSON = "{\n" + "    \"name\": \"nestor\",\n" + "    \"email\": \"nj058@domain.com\",\n"
				+ "    \"password\": \"pwd3J5fghj\",\n" + "    \"phone\": [\n" + "        {\n"
				+ "            \"number\": \"987483212\",\n" + "            \"citycode\": \"32\",\n"
				+ "            \"contrycode\": \"56\"\n" + "        }\n" + "    ]\n" + "}";

		Mockito.when(userService.createUser(Mockito.any(UserRq.class))).thenReturn(userRs);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/sign-up").accept(MediaType.APPLICATION_JSON)
				.content(myJSON).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}

}
