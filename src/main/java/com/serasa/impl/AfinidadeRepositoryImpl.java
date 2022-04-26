package com.serasa.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.serasa.interf.AfinidadeCustomMethods;

@Repository
public class AfinidadeRepositoryImpl implements AfinidadeCustomMethods {

    @PersistenceContext
    private EntityManager em;
}
