package com.serasa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serasa.business.PessoaBusinessObject;
import com.serasa.domain.Pessoa;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("api")
@CrossOrigin({"*"})
@Log4j2
public class PessoaController {

	@Autowired
	private PessoaBusinessObject pessoaBusinessObject;
	
	@PostMapping("pessoa")
    public ResponseEntity<Pessoa> addPessoa(@RequestBody Pessoa pessoa) {
		
		try {
			pessoaBusinessObject.addPessoa(pessoa);
			return new ResponseEntity<Pessoa>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Pessoa>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@GetMapping("pessoa/{id}")
    public ResponseEntity<Pessoa> getProductById(@PathVariable("id") Long id) {
		try {
			Optional<Pessoa> pessoa = pessoaBusinessObject.getPessoaById(id);
			if(pessoa != null) {
				return new ResponseEntity<Pessoa>(HttpStatus.CREATED);
			}else {
				return new ResponseEntity<Pessoa>(HttpStatus.NO_CONTENT);
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Pessoa>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
    }
	
	@SuppressWarnings("unchecked")
	@GetMapping("pessoa")
    public List<Pessoa> getPessoas() {
        
        try {
			List<Pessoa> pessoa = pessoaBusinessObject.getPessoas();
			if(pessoa != null) {
				return (List<Pessoa>) new ResponseEntity<List<Pessoa>>(HttpStatus.CREATED);
			}else {
				return (List<Pessoa>) new ResponseEntity<List<Pessoa>>(HttpStatus.NO_CONTENT);
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
			return (List<Pessoa>) new ResponseEntity<List<Pessoa>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
    
    @DeleteMapping("pessoa/{id}")
    public void deletePessoa(@PathVariable("id") Long number) {
    	pessoaBusinessObject.deletePessoa(number);
    }
    
    @GetMapping("teste")
    public String getTeste() {
        return pessoaBusinessObject.getTeste();
    }
    
    
}
