package com.serasa.interf;

import org.springframework.data.repository.query.Param;

import com.serasa.domain.Afinidade;

public interface AfinidadeRepositoryCustom {
	
	
	
	Afinidade getAfinidadeByRegiao(@Param("regiao") String regiao);

}
