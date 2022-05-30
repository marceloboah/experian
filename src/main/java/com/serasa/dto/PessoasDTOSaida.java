package com.serasa.dto;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Data
public class PessoasDTOSaida {
	
	private long id;
	
	private String nome;
	
	private Integer idade;
	
	private String cidade;
	
	private String estado;
	
	private String scoreDescricao;
	
	private List<String> estados;

}
