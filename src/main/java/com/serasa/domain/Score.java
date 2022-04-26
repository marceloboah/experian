package com.serasa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	@GeneratedValue
	private long id;
		
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "INICIAL")
	private Integer inicial;
	
	@Column(name = "FINAL")
	private Integer finnal;

}
