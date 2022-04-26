package com.serasa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serasa.business.PessoaBusinessObject;
import com.serasa.domain.Pessoa;

@RestController
@RequestMapping("api")
@CrossOrigin({"*"})
public class PessoaController {

	@Autowired
	private PessoaBusinessObject pessoaBusinessObject;
	
	@GetMapping("pessoa/{id}")
    public Optional<Pessoa> getProductById(@PathVariable("id") Long id) {
        return pessoaBusinessObject.getPessoaById(id);
    }
	
	@GetMapping("pessoas")
    public List<Pessoa> getPessoas() {
        return pessoaBusinessObject.getPessoas();
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
