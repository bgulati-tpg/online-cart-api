package com.onlinecartapi.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="usr")
public class User implements Serializable {
   
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "usr_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;
    
	@Column(name = "name")
    private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
    private String password;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "usr_id", referencedColumnName ="usr_id", insertable = false, updatable = false)
    private Set<UserRole> userRoles;

	public User() {

	}
	
	public User (User user) {
		this.userId = user.getUserId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.userRoles = user.getUserRoles();
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

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
}

