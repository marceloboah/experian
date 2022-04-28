package com.serasa.business;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasa.domain.Afinidade;
import com.serasa.domain.Pessoa;
import com.serasa.domain.Score;
import com.serasa.dto.PessoaDTOEntrada;
import com.serasa.repository.PessoaRepository;

@Service
public class PessoaBusinessObject {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ScoreBusinessObject scoreBusinessObject;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public Optional<Pessoa> getPessoaById(Long id) {
		 return pessoaRepository.findById(id);
   }
	
    public List<Pessoa> getPessoas() {
        return (List<Pessoa>) pessoaRepository.findAll();
    }

	public String getTeste() {
		return "Teste";
	}

	public void addPessoa(PessoaDTOEntrada pessoa) {		
		pessoaRepository.save(populatePessoaEntrada(pessoa));	
	}
    
	public Pessoa setDate(Pessoa pessoa) {
		Date date = new Date();
		formatter.format(date);
		pessoa.setDataInclusao(date);
		return pessoa;
	}
	
	public Pessoa populatePessoaEntrada(PessoaDTOEntrada pessoaDTO) {
		Pessoa pessoa = new Pessoa();
		pessoa.setCidade(pessoaDTO.getCidade());
		pessoa.setEstado(pessoaDTO.getEstado());
		pessoa.setIdade(pessoaDTO.getIdade());
		pessoa.setNome(pessoaDTO.getNome());
		//pessoa.setRegiao(pessoaDTO.getRegiao());
		Score score = scoreBusinessObject.getScoreByScore(pessoaDTO.getScore());
		pessoa.setScore(score.getScoreDescricao());
		pessoa.setTelefone(pessoaDTO.getTelefone());
		pessoa = setDate(pessoa);
		Afinidade afinidade = new Afinidade();
		afinidade.setRegiao(pessoaDTO.getRegiao());
		pessoa.setAfinidade(afinidade);
		return pessoa;	
	}

    
    
    
    

}
