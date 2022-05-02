package com.serasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.serasa.business.UserBusinessObject;
import com.serasa.domain.User;
import com.serasa.dto.UserDTO;

import lombok.extern.log4j.Log4j2;

@RestController
@CrossOrigin({"*"})
@Log4j2
public class UserController {
	
	@Autowired
	private UserBusinessObject userBusinessObject;
	
	@GetMapping("user")
    public ResponseEntity<UserDTO> getUser(@RequestBody UserDTO user) {
		
		try {
			userBusinessObject.getUser(user);
			return new ResponseEntity<UserDTO>(HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<UserDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
    }
	
	@PostMapping("user")
    public ResponseEntity<User> addScore(@RequestBody User user) {
		
		try {
			userBusinessObject.addUser(user);
			return new ResponseEntity<User>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
