package com.example.demo.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;




@Service
public class JwtUserDetailsService implements UserDetailsService {

    
	@Value(value = "${jwt.application.username}")
	String userName;
	@Value(value = "${jwt.application.pwd}")
	String pwd;
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            
            
		if ("knoldusnext".equals(username)) {
			return new User("knoldusnext", "$2a$10$ixlPY3AAd4ty1l6E2IsQ9OFZi2ba9ZQE0bP7RFcGIWNhyFrrT3YUi",
					new ArrayList<>());
		}
            else {
                    throw new UsernameNotFoundException("User not found with username: " + username);
            }                
	}

}