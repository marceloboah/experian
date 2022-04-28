package com.serasa.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasa.domain.Afinidade;
import com.serasa.domain.Estados;
import com.serasa.dto.AfinidadeDTO;
import com.serasa.repository.AfinidadeRepository;

@Service
public class AfinidadeBusinessObject {
	
	@Autowired
	private AfinidadeRepository afinidadeRepository;
	
	public Afinidade addAfinidade(AfinidadeDTO afinidade) {
    	return afinidadeRepository.save(this.addAfinidadeObj(afinidade));
    }

	public Afinidade addAfinidadeObj(AfinidadeDTO afinidadeDTO) {
		Afinidade afinidade = new Afinidade();
		List<Estados> listEstados = new ArrayList<Estados>();
		List<String> lista= afinidadeDTO.getEstados();
		for (Iterator<String> iterator = lista.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			Estados estados = new Estados();
			estados.setEstado(string);
			listEstados.add(estados);
		}		
		afinidade.setEstados(listEstados);
		afinidade.setRegiao(afinidadeDTO.getRegiao());
		return afinidade;
	}
	
	public Afinidade getAfinidadeByRegiao(String regiao) {
		Afinidade afinidade = afinidadeRepository.getAfinidadeByRegiao(regiao);
		return afinidade;
	}

}
