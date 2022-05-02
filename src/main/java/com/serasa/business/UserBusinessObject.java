package com.serasa.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.serasa.domain.User;
import com.serasa.dto.UserDTO;
import com.serasa.repository.UserRepository;

@Service
public class UserBusinessObject {
	
	@Autowired
	UserRepository userRepository;

	public User getUser(UserDTO userDTO) {
		User user = userRepository.findByUsername(userDTO.getUsername());
		return user;
	}
	
	public User getUser(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}
	
	
	public User addUser(User user) { 
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
		user.setPassword(passwordEncoder.encode(user.getPassword())); 
	    return userRepository.save(user); 
	}


}
