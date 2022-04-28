package com.serasa.interf;

import java.util.List;

import com.serasa.domain.Pessoa;



public interface PessoaRepositoryCustom {
	
	Pessoa getPessoaById(long id);
	List<Pessoa> getAllPessoa();

}
