package com.jwt.login.userInfoDto;

public class UserInfoDto {
	
	private String username;
	
	private String password;

	public UserInfoDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserInfoDto() {
		super();
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
