package com.globallogic.prueba.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.prueba.model.request.LoginRq;
import com.globallogic.prueba.model.response.MessageRs;
import com.globallogic.prueba.model.response.UserRs;
import com.globallogic.prueba.security.JWTAuthtenticationConfig;
import com.globallogic.prueba.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	JWTAuthtenticationConfig jwtAuthtenticationConfig;

	@Autowired
	private LoginService loginService;

	@PostMapping
	public ResponseEntity<Object> login(@RequestBody LoginRq loginRq) {

		UserRs user = loginService.getUserLogin(loginRq);
		if (user != null) {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} else {
			MessageRs msgRs = new MessageRs();
			LocalDateTime myDate = LocalDateTime.now();
			
			msgRs.setCodigo(HttpStatus.NOT_FOUND.value());
			msgRs.setTimestamp(myDate);
			msgRs.setDetail("Sin registros");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msgRs);
		}
	}

}