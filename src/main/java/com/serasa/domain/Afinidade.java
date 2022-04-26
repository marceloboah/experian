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
@DiscriminatorValue(value = "AFINIDADE")
@Getter 
@Setter
@NoArgsConstructor
public class Afinidade {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "TEXTO")
	private String texto;
	
	@Column(name = "LISTA")
	private String estados;

}
