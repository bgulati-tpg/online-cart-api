package com.onlinecartapi.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinecartapi.domain.CustomUserDetails;
import com.onlinecartapi.domain.User;
import com.onlinecartapi.domain.UserRole;
import com.onlinecartapi.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);	
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.info("In loadUserByUsername");
		Optional<User> optionalUser = userRepository.findByEmail(userName);
		CustomUserDetails customUserDetails; 
		
		if (optionalUser.isPresent()) {
			for (UserRole userRole : optionalUser.get().getUserRoles()) {
				log.info("userRole in loadUserBy NAme"+userRole.getRole().getRoleName());
			}
			customUserDetails = new CustomUserDetails(optionalUser.get());
		} else {
			throw new UsernameNotFoundException("User does not exist!!!");
		}
		return customUserDetails;
	}
	
	 // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(
            () -> new UsernameNotFoundException("User not found with id : " + email)
        );

        return new CustomUserDetails(user);
    }

}
