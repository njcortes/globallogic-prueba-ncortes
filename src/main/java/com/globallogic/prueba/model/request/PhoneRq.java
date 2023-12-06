package com.globallogic.prueba.model.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class PhoneRq {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "number")
	private String number;

	@Column(name = "citycode")
	private String citycode;

	@Column(name = "contrycode")
	private String contrycode;

	@ManyToOne
	@MapsId("userRq")
	@JoinColumn(name = "userRq_id")
	private UserRq userRq;

	public PhoneRq() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public UserRq getUserRq() {
		return userRq;
	}

	public void setUserRq(UserRq userRq) {
		this.userRq = userRq;
	}

	@Override
	public String toString() {
		return "PhoneRqDto [id=" + id + ", number=" + number + ", citycode=" + citycode + ", contrycode=" + contrycode
				+ ", userRq=" + userRq + "]";
	}

}
