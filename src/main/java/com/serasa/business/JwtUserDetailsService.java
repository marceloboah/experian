package com.serasa.business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
    private UserBusinessObject userService;
	
	@Value( "${jwt.username}" )
	private String username;
	
	@Value( "${jwt.secret}" )
	private String usersecret;
	
	@Value( "${jwt.authByProperties}" )
	private boolean authByProperties;//autentica via properties já que a base está vazia
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		com.serasa.domain.User user = new com.serasa.domain.User();
		com.serasa.dto.UserDTO userBusca = new com.serasa.dto.UserDTO();
    	if(authByProperties) {
    		user.setUsername(username);
    		user.setPassword(usersecret);
    	}else {
    		
    		userBusca.setUsername(name);
    		user = userService.getUser(userBusca);
    	}
    	
    	
		
		if (user != null) {
			return new User(user.getUsername(), user.getPassword(),new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}