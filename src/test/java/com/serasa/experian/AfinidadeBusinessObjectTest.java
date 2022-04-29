package com.serasa.experian;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.serasa.business.AfinidadeBusinessObject;
import com.serasa.domain.Afinidade;
import com.serasa.dto.AfinidadeDTO;

@RunWith(SpringRunner.class)
@SpringBootTest 
@AutoConfigureMockMvc
public class AfinidadeBusinessObjectTest {
	
	  @Autowired
	  private AfinidadeBusinessObject afinidadeBusinessObject;
	  

	  @Test
	  void addAfinidadeTest(){
		  AfinidadeDTO afinidadeDTO = new AfinidadeDTO();
		  List<String> list = new ArrayList<String>();
		  list.add("SP");
		  list.add("RJ");
		  list.add("MG");
		  list.add("ES");
		  afinidadeDTO.setRegiao("sudeste");
		  afinidadeDTO.setEstados(list);
		  
		  Afinidade afinidade = afinidadeBusinessObject.addAfinidade(afinidadeDTO);
		  assertEquals(afinidade, afinidade);
	  }

	  
	  @Test
	  void addAfinidadeObjTest(){
		  AfinidadeDTO afinidadeDTO = new AfinidadeDTO();
		  List<String> list = new ArrayList<String>();
		  list.add("SP");
		  list.add("RJ");
		  list.add("MG");
		  list.add("ES");
		  afinidadeDTO.setRegiao("sudeste");
		  afinidadeDTO.setEstados(list);
		  
		  Afinidade afinidade = afinidadeBusinessObject.addAfinidadeObj(afinidadeDTO);
		  assertEquals(afinidade, afinidade);
	  }

	  @Test
	  void getPessoaByIdTest(){
		  Afinidade afinidade = afinidadeBusinessObject.getAfinidadeByRegiao("sudeste");
		  assertEquals(afinidade, afinidade);
	  }
	   

}
