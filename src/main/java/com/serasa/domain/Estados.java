package com.serasa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Estados")
@Getter 
@Setter
@NoArgsConstructor
public class Estados {
	
	@Id
	@Column(name = "ESTADO")
    private String estado;

}
