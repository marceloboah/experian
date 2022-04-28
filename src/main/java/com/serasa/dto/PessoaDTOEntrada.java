package com.serasa.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Data
public class PessoaDTOEntrada {

	
	private String nome;
	
	private String telefone;
	
	private Integer idade;
	
	private String cidade;
	
	private String estado;
	
	private String regiao;
	
	private int score;
}
