package com.onlinecartapi.dto;

import java.io.Serializable;
import java.util.Set;

public class UserDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long userId;

    private String name;
	
	private String email;
	
    private String password;
    
    private Set<String> userRoles;
    
    public UserDto() {
    	
    }

	public UserDto(Long userId, String name, String email, String password, Set<String> userRoles) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.userRoles = userRoles;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Set<String> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<String> userRoles) {
		this.userRoles = userRoles;
	}
   
}
