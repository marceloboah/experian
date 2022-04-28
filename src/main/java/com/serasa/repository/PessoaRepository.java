package com.serasa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.serasa.domain.Pessoa;
import com.serasa.interf.PessoaRepositoryCustom;


@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> , PessoaRepositoryCustom {

	@Query("SELECT p FROM Pessoa p, Afinidade a WHERE p.regiao=a.regiao AND p.id = :id ")
	Pessoa getPessoaById(@Param("id") long id);
	
	@Query("SELECT p FROM Pessoa p ")
	List<Pessoa> getAllPessoa();

	
}