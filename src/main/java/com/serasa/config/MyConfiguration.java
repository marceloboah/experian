package com.serasa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import com.serasa.business.PessoaBusinessObject;

@Configuration
@EnableAutoConfiguration
public class MyConfiguration {
	
	@Autowired
	private PessoaBusinessObject pessoaBusinessObject;
	
	public MyConfiguration() {
		this.populateDataBase();
	}

	void populateDataBase() {
		System.out.println("Iniciou MyConfiguration");
		//pessoaBusinessObject.
	}

}
