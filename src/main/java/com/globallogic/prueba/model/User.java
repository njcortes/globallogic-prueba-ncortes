package com.globallogic.prueba.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOM_USER")
public class User {

	@Id
	@Column(name = "ID")
	private UUID id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "created")
	private LocalDateTime created;

	@Column(name = "lastLogin")
	private LocalDateTime lastLogin;

	@Column(name = "token", columnDefinition = "TEXT")
	private String token;

	@Column(name = "isActive")
	private Boolean isActive;

	@OneToMany(targetEntity = Phone.class, mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Phone> phone = new HashSet<>();

	public User() {

	}

	public User(String email, String password, String token) {
		this.email = email;
		this.password = password;
		this.token = token;
	}

	public User(UUID id) {
		this.id = id;
	}

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

	public Set<Phone> getPhone() {
		return phone;
	}

	public void setPhone(Set<Phone> phone) {
		this.phone = phone;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isactive) {
		this.isActive = isactive;
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
				+ ", lastLogin=" + lastLogin + ", token=" + token + ", isActive=" + isActive + ", phone=" + phone
				+ "]";
	}
}
