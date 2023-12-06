package com.globallogic.prueba.model.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserSignUpRs {
	private UUID id;
	private LocalDateTime created;
	private LocalDateTime lastLogin;
	private String token;
	private Boolean isactive;
	private String name;
	private String email;
	
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

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
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

	@Override
	public String toString() {
		return "UserRsInsert [id=" + id + ", name=" + name + ", email=" + email + ", created=" + created
				+ ", lastLogin=" + lastLogin + ", token=" + token + ", isactive=" + isactive + "]";
	}

}
