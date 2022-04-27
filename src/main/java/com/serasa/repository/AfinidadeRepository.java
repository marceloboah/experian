package com.serasa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.serasa.domain.Afinidade;
import com.serasa.interf.AfinidadeRepositoryCustom;


@Repository
public interface AfinidadeRepository extends CrudRepository<Afinidade, Long> , AfinidadeRepositoryCustom {

	
	
	
}
