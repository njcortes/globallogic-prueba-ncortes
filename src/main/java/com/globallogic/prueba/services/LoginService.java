package com.globallogic.prueba.services;

import com.globallogic.prueba.model.request.LoginRq;
import com.globallogic.prueba.model.response.UserRs;

public interface LoginService {

	public UserRs getUserLogin(LoginRq loginRq);
}
