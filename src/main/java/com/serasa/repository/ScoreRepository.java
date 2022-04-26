package com.serasa.repository;

import org.springframework.data.repository.CrudRepository;

import com.serasa.domain.Score;
import com.serasa.interf.ScoreRepositoryCustom;

public interface ScoreRepository  extends CrudRepository<Score, Long> , ScoreRepositoryCustom {

	
	
	
}