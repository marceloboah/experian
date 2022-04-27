package com.serasa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.serasa.domain.Pessoa;
import com.serasa.interf.PessoaRepositoryCustom;


@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> , PessoaRepositoryCustom {

	
	
	
}