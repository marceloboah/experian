package com.serasa.experian;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.serasa.business.ScoreBusinessObject;
import com.serasa.domain.Score;


@RunWith(SpringRunner.class)
@SpringBootTest 
@AutoConfigureMockMvc
public class ScoreBusinessObjectTest {
	

	  @Autowired
	  private ScoreBusinessObject scoreBusinessObject;

	  
	  @Test
	  void addScoreTest() {
		    Score score = scoreBusinessObject.doPopulate("Insuficiente", 0, 200);
		    score = scoreBusinessObject.addScore(score);
		    assertEquals("Insuficiente", score.getScoreDescricao());
	  }
	  
	  @Test
	  void addScorePopulateTest() {
		  boolean teste = false;
		  teste = scoreBusinessObject.addScorePopulate();
		  assertEquals(teste, true);
	  }

	  @Test
	  void doPopulateTest() {
		    Score score = scoreBusinessObject.doPopulate("Insuficiente", 0, 200);
		    assertEquals("Insuficiente", score.getScoreDescricao());
	  } 
	  
	  @Test
	  void populateScoreDTOTest() {
		    Score score = new Score();
		    score.setInicial(0);
		    score.setFinnal(200);
		    Score scoreVerify = new Score();
		    Score scoreToTeste = scoreBusinessObject.populateScoreDTO(scoreVerify,score);
		    assertEquals(0, scoreToTeste.getInicial());
		    assertEquals(200, scoreToTeste.getFinnal());
	  }
	  
	  @Test
	  void getScoreByScoreTest() {
		    Score score = scoreBusinessObject.getScoreByScore(2);
		    assertEquals("Insuficiente", score.getScoreDescricao());
	  }
	  
}
