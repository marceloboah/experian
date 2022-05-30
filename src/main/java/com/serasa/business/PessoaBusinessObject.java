package com.serasa.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasa.domain.Afinidade;
import com.serasa.domain.Estados;
import com.serasa.domain.Pessoa;
import com.serasa.domain.Score;
import com.serasa.dto.PessoaDTOEntrada;
import com.serasa.dto.PessoaDTOSaida;
import com.serasa.dto.PessoasDTOSaida;
import com.serasa.repository.PessoaRepository;

@Service
public class PessoaBusinessObject {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ScoreBusinessObject scoreBusinessObject;
	
	@Autowired
	private AfinidadeBusinessObject afinidadeBusinessObject;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public PessoaDTOSaida getPessoaById(Long id) {
		 Pessoa pessoa = pessoaRepository.getPessoaById(id);
		 PessoaDTOSaida pessoaDTOSaida = new PessoaDTOSaida();
		 if(pessoa != null) {
			 Afinidade afinidade = afinidadeBusinessObject.getAfinidadeByRegiao(pessoa.getRegiao());
			 List<String> listaEstados = new ArrayList<String>();
			 if(afinidade.getEstados() != null) {
				 for (Iterator<Estados> iterator = afinidade.getEstados().iterator(); iterator.hasNext();) {
					 Estados estado = (Estados) iterator.next();
					 listaEstados.add(estado.getEstado());
				}
				 pessoaDTOSaida = this.populatePessoaSaida(pessoa);
				 pessoaDTOSaida.setEstados(listaEstados);
			 }
			 
		 }else {
			 pessoaDTOSaida = null;
		 }
		 return pessoaDTOSaida;
   }
	
    public List<PessoasDTOSaida> getPessoas() {
    	List<PessoasDTOSaida> listPessoasDTOSaida = new ArrayList<PessoasDTOSaida>();
    	List<Pessoa> listPessoas = (List<Pessoa>) pessoaRepository.findAll();
    	for (Iterator<Pessoa> iterator = listPessoas.iterator(); iterator.hasNext();) {
			Pessoa pessoa = (Pessoa) iterator.next();
			Afinidade afinidade = afinidadeBusinessObject.getAfinidadeByRegiao(pessoa.getRegiao());
			List<String> listaEstados = new ArrayList<String>();
			if(afinidade != null) {
				for (Iterator<Estados> iterator2 = afinidade.getEstados().iterator(); iterator2.hasNext();) {
					 Estados estado = (Estados) iterator2.next();
					 listaEstados.add(estado.getEstado());
				}
				pessoa.setEstadosString(listaEstados);
				PessoasDTOSaida pessoasDTOSaida = new PessoasDTOSaida();
				pessoasDTOSaida = this.populateAllPessoasSaida(pessoa);
				listPessoasDTOSaida.add(pessoasDTOSaida);
			}
			
		}
        return listPessoasDTOSaida;
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
		pessoa.setRegiao(pessoaDTO.getRegiao());
		Score score = scoreBusinessObject.getScoreByScore(pessoaDTO.getScore());
		pessoa.setScore(score.getScoreDescricao());
		pessoa.setTelefone(pessoaDTO.getTelefone());
		pessoa = setDate(pessoa);
		Afinidade afinidade = new Afinidade();
		afinidade.setRegiao(pessoaDTO.getRegiao());
		return pessoa;	
	}
    
	public PessoaDTOSaida populatePessoaSaida(Pessoa pessoa) {
		
		PessoaDTOSaida pessoaDTO = new PessoaDTOSaida();
		pessoaDTO.setNome(pessoa.getNome());
		pessoaDTO.setTelefone(pessoa.getTelefone());
		pessoaDTO.setIdade(pessoa.getIdade());
		pessoaDTO.setScoreDescricao(pessoa.getScore());
		return pessoaDTO;
		
	}
	
	public PessoasDTOSaida populateAllPessoasSaida(Pessoa pessoa) {
		
		PessoasDTOSaida pessoaDTO = new PessoasDTOSaida();
		pessoaDTO.setId(pessoa.getId());
		pessoaDTO.setNome(pessoa.getNome());
		pessoaDTO.setIdade(pessoa.getIdade());
		pessoaDTO.setCidade(pessoa.getCidade());
		pessoaDTO.setEstado(pessoa.getEstado());
		pessoaDTO.setScoreDescricao(pessoa.getScore());
		pessoaDTO.setEstados(pessoa.getEstadosString());
		return pessoaDTO;
		
	}
	

}
