package com.serasa.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@DiscriminatorValue(value = "PESSOA")
@Getter 
@Setter
@NoArgsConstructor
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
		
	@Column(name = "DATA_INCLUSAO")
	private Date dataInclusao;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "IDADE")
	private Integer idade;
	
	@Column(name = "CIDADE")
	private String cidade;
	
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "REGIAO")
	private String regiao;
	
	@Transient
	private int score;

}
