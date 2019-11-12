package com.parkingsystem.model.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginPOJO {

	@NotBlank(message="{email.NotBlank}")
	@Email(message="{email.ValidEmail}")
	private String email;
	
	@NotBlank(message="{password.NotBlank}")
	@Pattern(regexp="[a-zA-Z0-9]+", message="{password.OnlyAlphanumeric}")
	@Size(min=8,max=16, message="{password.Length}")
	private String password;
	
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
}
