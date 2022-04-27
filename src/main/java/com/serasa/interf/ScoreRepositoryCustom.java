package com.serasa.interf;

import com.serasa.domain.Score;

public interface ScoreRepositoryCustom {
	
	Score findProductByParam(String scoreDescricao);
	
}
