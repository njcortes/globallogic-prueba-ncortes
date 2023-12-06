package com.globallogic.prueba.util.formater;

import java.util.HashSet;

import com.globallogic.prueba.model.Phone;
import com.globallogic.prueba.model.User;
import com.globallogic.prueba.model.response.PhoneRs;
import com.globallogic.prueba.model.response.UserRs;

public class UserLoginFormater implements Formater<User> {

	@Override
	public UserRs format(User u) {
		UserRs user = new UserRs();
		user.setId(u.getId());
		user.setName(u.getName());
		user.setPassword(u.getPassword());
		user.setEmail(u.getEmail());
		user.setToken(u.getToken());
		user.setCreated(u.getCreated());
		user.setIsactive(u.getIsActive());
		user.setLastLogin(u.getLastLogin());

		HashSet<PhoneRs> hsPhone = new HashSet<PhoneRs>();
		if (u.getPhone() != null) {
			for (Phone p : u.getPhone()) {

				PhoneRs phone = new PhoneRs();
				phone.setNumber(p.getNumber());
				phone.setCitycode(p.getCitycode());
				phone.setContrycode(p.getContrycode());
				hsPhone.add(phone);
			}

			user.setPhones(hsPhone);
		}
		user.setPhones(hsPhone);
		return user;
	}
}
