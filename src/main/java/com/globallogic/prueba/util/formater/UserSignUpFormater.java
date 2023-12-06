package com.globallogic.prueba.util.formater;

import com.globallogic.prueba.model.User;
import com.globallogic.prueba.model.response.UserSignUpRs;

public class UserSignUpFormater implements Formater<User> {

	@Override
	public UserSignUpRs format(User u) {
		UserSignUpRs user = new UserSignUpRs();
		user.setId(u.getId());
		user.setName(u.getName());
		user.setEmail(u.getEmail());
		user.setToken(u.getToken());
		user.setCreated(u.getCreated());
		user.setIsactive(u.getIsActive());
		user.setLastLogin(u.getLastLogin());
		return user;
	}

}
