package com.serasa.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasa.domain.Score;
import com.serasa.repository.ScoreRepository;

@Service
public class ScoreBusinessObject {
	
	@Autowired
	ScoreRepository scoreRepository;
	
	public Score addScore(Score score) {
		Score scoreVerify = new Score();
		scoreVerify = scoreRepository.findProductByParam(score.getScoreDescricao());
    	if (scoreVerify != null) {
    		Score scoreAtualizado = this.populateScoreDTO(scoreVerify,score);
    		return scoreRepository.save(scoreAtualizado);
    	}
    	return scoreRepository.save(score);
    }
	
	public void addScorePopulate() {	
		this.doPopulate("Insuficiente", 0, 200);
		this.doPopulate("Inaceitável", 201, 500);
		this.doPopulate("Aceitável", 501, 700);
		this.doPopulate("Recomendável", 701, 1000);
	}
	
	public Score doPopulate(String descricao, int inicial, int finnal) {
		Score score = new Score();
		score.setScoreDescricao(descricao);
		score.setInicial(inicial);
		score.setFinnal(finnal);
		score = scoreRepository.save(score);
		return score;	
	}
	
	public Score populateScoreDTO(Score scoreVerify, Score score) {
		scoreVerify.setInicial(score.getInicial());
		scoreVerify.setFinnal(score.getFinnal());
		return scoreVerify;
	}


}
