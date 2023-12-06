package com.globallogic.prueba.util.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailValidator implements Validator {

	//TODO mover a archivo de configuracion
	private final String strValidacionPatronCorreo = "[A-Za-z0-9+_.-]+@(.+)$";

	@Override
	public Boolean validate(String email) {
		Pattern pattern = Pattern.compile(strValidacionPatronCorreo);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
