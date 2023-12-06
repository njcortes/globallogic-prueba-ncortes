package com.globallogic.prueba.model.response;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UserRs {

	private UUID id;
	private LocalDateTime created;
	private LocalDateTime lastLogin;
	private String token;
	private Boolean isactive;
	private String name;
	private String email;
	private String password;
	private Set<PhoneRs> phones = new HashSet<>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public Set<PhoneRs> getPhones() {
		return phones;
	}

	public void setPhones(Set<PhoneRs> phones) {
		this.phones = phones;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", created=" + created
				+ ", token=" + token + ", isactive=" + isactive + ", lastLogin="
				+ lastLogin + ", phones=" + phones + "]";
	}

}