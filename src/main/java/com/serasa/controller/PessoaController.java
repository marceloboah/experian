package com.serasa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.serasa.business.PessoaBusinessObject;
import com.serasa.domain.Pessoa;
import com.serasa.dto.PessoaDTOEntrada;

import lombok.extern.log4j.Log4j2;

@RestController
@CrossOrigin({"*"})
@Log4j2
public class PessoaController {

	@Autowired
	private PessoaBusinessObject pessoaBusinessObject;
	
	@PostMapping("pessoa")
    public ResponseEntity<Object> addPessoa(@RequestBody PessoaDTOEntrada pessoa) throws Exception {
		if(pessoa != null && pessoa.getScore() > 1000 || pessoa.getScore() < 0) {
			throw new Exception("Score Inválido! Score precisa estar entre 0 e 1000!");
		}
		try {
			pessoaBusinessObject.addPessoa(pessoa);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@GetMapping("pessoa/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Long id) {
		try {
			Optional<Pessoa> pessoa = pessoaBusinessObject.getPessoaById(id);
			if(pessoa != null) {
				return new ResponseEntity<Object>(pessoa,HttpStatus.CREATED);
			}else {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
    }
	

	@GetMapping("pessoa")
    public ResponseEntity<Object> getPessoas() {
        
        try {
			List<Pessoa> pessoa = pessoaBusinessObject.getPessoas();
			if(!pessoa.isEmpty() && pessoa.get(0) != null && pessoa.get(0).getId() >0) {
				return new ResponseEntity<Object>(pessoa,HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
    
    @GetMapping("teste")
    public String getTeste() {
        return pessoaBusinessObject.getTeste();
    }
    
    
}
