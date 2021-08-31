package com.onlinecartapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinecartapi.domain.User;
import com.onlinecartapi.domain.UserDto;
import com.onlinecartapi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<UserDto> getAllUsers() {
		List<User> userList = userRepository.findAll();
		List<UserDto> userListDto = new ArrayList<>(); 
		for (User user : userList) {
			Set<String> roles = user.getUserRoles().stream()
	                .map(role -> role.getRole().getRoleName())
	                .collect(Collectors.toSet());
			userListDto.add(new UserDto(user.getUserId(), user.getName(), user.getEmail(), user.getPassword(), roles));
		}
		return userListDto;
	}
	
	public Optional<User> authenticateUser(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public Optional<User> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
