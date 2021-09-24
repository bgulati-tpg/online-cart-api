package com.onlinecartapi.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "role_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long roleId;
    
	@Column(name = "role")
    private String roleName;
	
    @OneToMany
	@JoinColumn(name = "role_id", referencedColumnName ="role_id", insertable = false, updatable = false)
    private Set<UserRole> userRoles;

    public Role() {
    	
    }
	public Role(Long roleId) {
		super();
		this.roleId = roleId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
