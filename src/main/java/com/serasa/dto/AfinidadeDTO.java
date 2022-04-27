package com.serasa.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Data
public class AfinidadeDTO {
	
	@JsonProperty("regiao")
	private String regiao;
	
	@JsonProperty("estados")
	private List<String> estados;

}
