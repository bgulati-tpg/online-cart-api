package com.onlinecartapi.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usr_role")
public class UserRole implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName ="role_id", insertable = false, updatable = false)
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "usr_id", referencedColumnName ="usr_id", insertable = false, updatable = false)
	private User user;
	
	@EmbeddedId
	private UserRolePk userRolePk;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserRolePk getUserRolePk() {
		return userRolePk;
	}

	public void setUserRolePk(UserRolePk userRolePk) {
		this.userRolePk = userRolePk;
	}
	
}
