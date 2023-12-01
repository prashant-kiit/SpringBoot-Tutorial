package com.example.securitydemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Userdetail {
	
	@Id
	private String username;
	
	@Column(length = 68)
	private String password;
	
	@Column(columnDefinition="tinyint(1) default 1")
	private boolean enabled;
	
	public String getUser() {
		return username;
	}
	
	public void setUser(String username) {
		this.username = username;
	}
	
	public String getPass() {
		return password;
	}
	
	public void setPass(String password) {
		this.password = password;
	}
	
	public boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
		
}
