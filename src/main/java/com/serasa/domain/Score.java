package com.serasa.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@DiscriminatorValue(value = "SCORE")
@Getter 
@Setter
@NoArgsConstructor
public class Score {
		
	@Id
	@Column(name = "SCORE_DESCRICAO")
	private String scoreDescricao;
	
	@Column(name = "INICIAL")
	private Integer inicial;
	
	@Column(name = "FINAL")
	@JsonProperty("final")
	private Integer finnal;

}
