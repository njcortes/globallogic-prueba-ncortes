package com.globallogic.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.prueba.model.request.UserRq;
import com.globallogic.prueba.model.response.MessageRs;
import com.globallogic.prueba.model.response.UserSignUpRs;
import com.globallogic.prueba.services.SignUpService;

@RestController
@RequestMapping("/sign-up")
public class SignUpController {

	@Autowired
	private SignUpService signUpService;

	@PostMapping
	public ResponseEntity<Object> createUser(@RequestBody UserRq userRq) {
		MessageRs msgRs = signUpService.createUser(userRq);

		if (msgRs.getCodigo() == HttpStatus.CREATED.value()) {
			UserSignUpRs usr = signUpService.getUserSignUp(msgRs.getDetail());
			return ResponseEntity.status(HttpStatus.CREATED).body(usr);

		} else {
			return ResponseEntity.status(msgRs.getCodigo()).body(msgRs);
		}

	}

}
