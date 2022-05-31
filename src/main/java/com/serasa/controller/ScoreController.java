package com.serasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.serasa.business.ScoreBusinessObject;
import com.serasa.domain.Score;

import lombok.extern.log4j.Log4j2;

@RestController
@CrossOrigin({"*"})
@Log4j2
public class ScoreController {
	
	@Autowired
	private ScoreBusinessObject scoreBusinessObject;
	
	@GetMapping("score/populate")
    public ResponseEntity<Score> getPopulateProducts() {
		
		try {
			scoreBusinessObject.addScorePopulate();
			return new ResponseEntity<Score>(HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Score>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
    }
	
	@PostMapping("score")
    public ResponseEntity<Score> addScore(@RequestBody Score score) {
		
		try {
			scoreBusinessObject.addScore(score);
			return new ResponseEntity<Score>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Score>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@GetMapping("score")
    public ResponseEntity<List<Score>> getScore() {
		
		try {
			List<Score> scoreList = scoreBusinessObject.getScore();
			return new ResponseEntity<List<Score>>(scoreList,HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<List<Score>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	

}
