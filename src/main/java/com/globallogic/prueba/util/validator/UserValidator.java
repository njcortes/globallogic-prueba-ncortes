package com.globallogic.prueba.util.validator;

import com.globallogic.prueba.model.User;
import com.globallogic.prueba.repositories.UserRepository;

public class UserValidator implements Validator {

	private UserRepository userRepo;

	public UserValidator(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public Boolean validate(String email) {
		Iterable<User> itUser = userRepo.findAll();
		if (itUser != null) {
			for (User u : itUser) {

				if (email.equalsIgnoreCase(u.getEmail())) {
					return true;
				}
			}
		}
		return false;

	}

}
