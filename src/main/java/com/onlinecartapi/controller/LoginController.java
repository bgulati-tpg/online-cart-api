package com.onlinecartapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinecartapi.domain.User;
import com.onlinecartapi.dto.LoginDto;
import com.onlinecartapi.dto.UserDto;
import com.onlinecartapi.security.JwtAuthenticationResponse;
import com.onlinecartapi.security.JwtTokenProvider;
import com.onlinecartapi.service.UserService;


@RestController
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);	
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
    JwtTokenProvider tokenProvider;
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDto loginDto) {
		String jwt  = null;
		Optional<User> optionalUser = userService.authenticateUser(loginDto.getEmail(), loginDto.getPassword());
		if (optionalUser.isPresent()) {			
			final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                		loginDto.getEmail(),
	                		loginDto.getPassword()
	                )
	        );
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        jwt = tokenProvider.generateToken(authentication);   	
		}
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping(value = "/dashboard", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getDashboard() {
		log.info("I am in getDashboard");
		List<UserDto> usersList =  userService.getAllUsers();
		log.info("I am in before getDashboard exit"+usersList);
		return ResponseEntity.ok(usersList);
					
	}

}
