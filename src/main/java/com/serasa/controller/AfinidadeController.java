package com.serasa.controller;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("api")
@CrossOrigin({"*"})
@Log4j2
public class AfinidadeController {
	
	@GetMapping("/response_entity")
    public ResponseEntity<String> withResponseEntity() {
		log.debug("A DEBUG Message");
        return ResponseEntity.status(HttpStatus.SC_OK).body("Teste HTTP Status realizado");
    }

}
