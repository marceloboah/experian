package com.serasa.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class ScoreRepositoryImpl {

	
	 @PersistenceContext private EntityManager em;
	 
}
