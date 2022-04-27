package com.serasa.domain;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	
	/*@Id
    @GeneratedValue
    private Long id;*/
	
	@Id
    private String estado;

}
