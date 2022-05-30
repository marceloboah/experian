package com.serasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.serasa.business.AfinidadeBusinessObject;
import com.serasa.domain.Afinidade;
import com.serasa.dto.AfinidadeDTO;

import lombok.extern.log4j.Log4j2;

@RestController
@CrossOrigin({"*"})
@Log4j2
public class AfinidadeController {
	
	@Autowired
	AfinidadeBusinessObject afinidadeBusinessObject;
		
		
	@GetMapping("/response_entity")
    public ResponseEntity<String> withResponseEntity() {
		return ResponseEntity.status(HttpStatus.OK).body("Teste HTTP Status realizado");
    }
	
	@PostMapping("/afinidade")
    public ResponseEntity<Afinidade> addScore(@RequestBody AfinidadeDTO afinidadeDTO) {
		
		try {
			afinidadeBusinessObject.addAfinidade(afinidadeDTO);
			return new ResponseEntity<Afinidade>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Afinidade>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@GetMapping("/afinidade")
    public ResponseEntity<List<Afinidade>> getAfinidade() {
		
		try {
			List<Afinidade> listAfinidades = afinidadeBusinessObject.getAfinidades();
			return new ResponseEntity<List<Afinidade>>(listAfinidades,HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<List<Afinidade>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
