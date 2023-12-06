package com.globallogic.prueba.util.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements Validator {

	//TODO mover a archivo de configuracion
	private final String strValidacionPatronClave = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,12}$";

	@Override
	public Boolean validate(String password) {
		Pattern pattern = Pattern.compile(strValidacionPatronClave);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

}
