package com.onlinecartapi.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinecartapi.domain.User;
import com.onlinecartapi.domain.UserDto;
import com.onlinecartapi.dto.LoginDto;
import com.onlinecartapi.security.JwtAuthenticationResponse;
import com.onlinecartapi.security.JwtTokenProvider;
import com.onlinecartapi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	//private static final Logger log = LoggerFactory.getLogger(UserController.class);	
	
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
	@GetMapping(value = "/list")
	public List<UserDto> getAllUsers() {	
		List<UserDto> usersList =  userService.getAllUsers();
		return usersList;	
	}
	
	@GetMapping(value="/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null) {    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "User has been successfully logout.";
	}

}
