package com.serasa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="AFINIDADE")
@Getter 
@Setter
@NoArgsConstructor
public class Afinidade {
	

	@Id
	@Column(name = "REGIAO")
	private String regiao;
	
	
	@Column(name = "ESTADOS")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Estados> estados = new ArrayList<Estados>();
	

}
