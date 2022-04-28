package com.serasa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "REGIAO")
	private String regiao;
	
	
	@Column(name = "ESTADOS")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Estados> estados = new ArrayList<Estados>();
	

}
