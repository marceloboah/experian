package com.serasa.interf;

import com.serasa.domain.Score;

public interface ScoreRepositoryCustom {
	
	Score findScoreByParam(String scoreDescricao);
	Score findScoreBetweenParam(int score);
	
}
