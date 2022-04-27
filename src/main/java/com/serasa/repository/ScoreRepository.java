package com.serasa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.serasa.domain.Score;
import com.serasa.interf.ScoreRepositoryCustom;


@Repository
public interface ScoreRepository  extends CrudRepository<Score, Long> , ScoreRepositoryCustom {
	
	@Query("SELECT s FROM Score s WHERE s.scoreDescricao LIKE :scoreDescricao ")
	Score findProductByParam(@Param("scoreDescricao") String scoreDescricao);
	
	
	
	
	
}