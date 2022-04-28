package com.serasa.dto;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Data
public class PessoaDTOSaida {

	private String nome;
	
	private String telefone;
	
	private Integer idade;
	
	private String scoreDescricao;
	
	private List<String> estados;
}
