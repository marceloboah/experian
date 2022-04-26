package com.serasa.repository;

import org.springframework.data.repository.CrudRepository;

import com.serasa.domain.Afinidade;
import com.serasa.interf.AfinidadeRepositoryCustom;

public interface AfinidadeRepository extends CrudRepository<Afinidade, Long> , AfinidadeRepositoryCustom {

	
	
	
}
