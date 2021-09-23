package com.onlinecartapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinecartapi.domain.UserRole;
import com.onlinecartapi.domain.UserRolePk;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRolePk> {
	

}
