package com.serasa.business;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.serasa.domain.Pessoa;
import com.serasa.repository.PessoaRepository;

@Service
public class PessoaBusinessObject {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public Optional<Pessoa> getPessoaById(Long id) {
		 return pessoaRepository.findById(id);
   }
	
    public List<Pessoa> getPessoas() {
        return (List<Pessoa>) pessoaRepository.findAll();
    }

	public void deletePessoa(Long id) {
		pessoaRepository.deleteById(id);		
	}

	public String getTeste() {
		return "Teste";
	}

	public void addPessoa(Pessoa pessoa) {
		pessoa = setDate(pessoa);
		pessoaRepository.save(pessoa);	
	}
    
	public Pessoa setDate(Pessoa pessoa) {
		Date date = new Date();
		formatter.format(date);
		pessoa.setDataInclusao(date);
		return pessoa;
	}

    
    
    
    

}
