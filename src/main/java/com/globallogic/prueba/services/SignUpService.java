package com.globallogic.prueba.services;

import com.globallogic.prueba.model.request.UserRq;
import com.globallogic.prueba.model.response.MessageRs;
import com.globallogic.prueba.model.response.UserRs;
import com.globallogic.prueba.model.response.UserSignUpRs;

public interface SignUpService {

	public MessageRs createUser(UserRq userRq);

	public UserSignUpRs getUserSignUp(String userId);

	public UserRs getUserLogin(String userId);

	public UserRs getUser(String userId);
}
