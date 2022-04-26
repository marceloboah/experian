package com.serasa.repository;

import org.springframework.data.repository.CrudRepository;

import com.serasa.domain.Pessoa;
import com.serasa.interf.PessoaRepositoryCustom;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> , PessoaRepositoryCustom {

	
	
	
}