package com.onlinecartapi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserRolePk implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "usr_id")
    private Long userId;
	
	@Column(name = "role_id")
    private Long roleId;

	public UserRolePk() {
		
	}
	
	public UserRolePk(Long userId, Long roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
    
}
