package com.globallogic.prueba.model.response;

public class PhoneRs {
	private String number;
	private String citycode;
	private String contrycode;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getContrycode() {
		return contrycode;
	}

	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

	@Override
	public String toString() {
		return "PhoneRqDto [number=" + number + ", citycode=" + citycode + ", contrycode=" + contrycode + "]";
	}
}
