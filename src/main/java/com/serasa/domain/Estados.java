package com.serasa.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Estados")
@DiscriminatorValue(value = "ESTADOS")
@Getter 
@Setter
@NoArgsConstructor
public class Estados {
	
	@Id
    private String estado;

}
