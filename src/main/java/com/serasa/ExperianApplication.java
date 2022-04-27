package com.serasa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.serasa.business.ScoreBusinessObject;
import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@EnableAutoConfiguration
@Log4j2
public class ExperianApplication implements CommandLineRunner {

	@Autowired
	private ScoreBusinessObject scoreBusinessObject;
	
	public static void main(String[] args) {
		SpringApplication.run(ExperianApplication.class, args);
	}


	public void run(String... args) throws Exception {
		log.debug("Iniciou runner");
		scoreBusinessObject.addScorePopulate();
		log.debug("Finalizou runner");      
		
	}

}
