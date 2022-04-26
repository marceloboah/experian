package com.serasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ExperianApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExperianApplication.class, args);
		ExperianApplication experianApplication = new ExperianApplication();
		experianApplication.initializer();
	}

	void initializer() {
        System.out.println("Hello World>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"); 
    }

}
