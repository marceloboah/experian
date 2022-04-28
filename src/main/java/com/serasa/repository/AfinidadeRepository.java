package com.serasa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.serasa.domain.Afinidade;
import com.serasa.interf.AfinidadeRepositoryCustom;


@Repository
public interface AfinidadeRepository extends CrudRepository<Afinidade, Long> , AfinidadeRepositoryCustom {

	@Query("SELECT a FROM Afinidade a WHERE a.regiao= :regiao ")
	Afinidade getAfinidadeByRegiao(@Param("regiao") String regiao);
	
	
}
