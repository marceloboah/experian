package com.serasa.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.serasa.domain.Pessoa;

@Repository
public class PessoaRepositoryImpl {

	
	 @PersistenceContext private EntityManager em;
	 
	 
	 public List<Pessoa> getAllPessoa() { CriteriaBuilder cb =
	 em.getCriteriaBuilder(); CriteriaQuery<Pessoa> criteriaQuery =
	 cb.createQuery(Pessoa.class); Root<Pessoa> ptable =
	 criteriaQuery.from(Pessoa.class); criteriaQuery.select(ptable);
	 criteriaQuery.orderBy(cb.asc(ptable.get("id"))); TypedQuery<Pessoa> query =
	 em.createQuery(criteriaQuery); List<Pessoa> list = query.getResultList();
	 return list; }
	
}
