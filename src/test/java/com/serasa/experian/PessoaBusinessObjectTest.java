package com.serasa.experian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.serasa.business.PessoaBusinessObject;
import com.serasa.domain.Pessoa;
import com.serasa.dto.PessoaDTOEntrada;
import com.serasa.dto.PessoaDTOSaida;
import com.serasa.dto.PessoasDTOSaida;
import com.serasa.dto.AfinidadeDTO;

@RunWith(SpringRunner.class)
@SpringBootTest 
@AutoConfigureMockMvc(addFilters = false)
public class PessoaBusinessObjectTest {
	
	  @Autowired
	  private PessoaBusinessObject pessoaBusinessObject;
	  
	  @Autowired
	  private MockMvc mockMvc;
	  
	  @Test
	  public void getPessoaByIdTest() throws Exception{
		  AfinidadeDTO afinidadeDTO = new AfinidadeDTO();
		  List<String> list = new ArrayList<String>();
		  list.add("PR");
		  list.add("SC");
		  list.add("RS");
		  afinidadeDTO.setRegiao("sul");
		  afinidadeDTO.setEstados(list);		  
		 
		  
		  ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		  String json = ow.writeValueAsString(afinidadeDTO);
		  
		  this.mockMvc.perform(MockMvcRequestBuilders
			      .post("/afinidade")
			      .content(json)
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(MockMvcResultMatchers.status().isCreated());
		  
		  
			
			 PessoaDTOEntrada pessoaDTOEntrada = new PessoaDTOEntrada();
			 pessoaDTOEntrada.setNome("Marcelo");
			 pessoaDTOEntrada.setTelefone("41 999999999");
			 pessoaDTOEntrada.setIdade(45);
			 pessoaDTOEntrada.setCidade("Curitiba"); 
			 pessoaDTOEntrada.setEstado("PR");
			 pessoaDTOEntrada.setRegiao("sul"); 
			 pessoaDTOEntrada.setScore(1000);
			 
			 json = ow.writeValueAsString(pessoaDTOEntrada);
			 
			 this.mockMvc.perform(MockMvcRequestBuilders
				      .post("/pessoa")
				      .content(json)
				      .contentType(MediaType.APPLICATION_JSON)
				      .accept(MediaType.APPLICATION_JSON))
				      .andExpect(MockMvcResultMatchers.status().isCreated());
			 
			 this.mockMvc.perform(MockMvcRequestBuilders.get("/pessoa/1"))
	          .andExpect(MockMvcResultMatchers.status().isOk())
	          .andDo(MockMvcResultHandlers.print());
          
	  }
	  
		
	 @Test 
	 public void getPessoasTest() throws Exception{ 
		 AfinidadeDTO afinidadeDTO = new AfinidadeDTO();
		  List<String> list = new ArrayList<String>();
		  list.add("PR");
		  list.add("SC");
		  list.add("RS");
		  afinidadeDTO.setRegiao("sul");
		  afinidadeDTO.setEstados(list);		  
		 
		  
		  ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		  String json = ow.writeValueAsString(afinidadeDTO);
		  
		  this.mockMvc.perform(MockMvcRequestBuilders
			      .post("/afinidade")
			      .content(json)
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(MockMvcResultMatchers.status().isCreated());
		  
		  
			
			 PessoaDTOEntrada pessoaDTOEntrada = new PessoaDTOEntrada();
			 pessoaDTOEntrada.setNome("Marcelo");
			 pessoaDTOEntrada.setTelefone("41 999999999");
			 pessoaDTOEntrada.setIdade(45);
			 pessoaDTOEntrada.setCidade("Curitiba"); 
			 pessoaDTOEntrada.setEstado("PR");
			 pessoaDTOEntrada.setRegiao("sul"); 
			 pessoaDTOEntrada.setScore(1000);
			 
			 json = ow.writeValueAsString(pessoaDTOEntrada);
			 
			 this.mockMvc.perform(MockMvcRequestBuilders
				      .post("/pessoa")
				      .content(json)
				      .contentType(MediaType.APPLICATION_JSON)
				      .accept(MediaType.APPLICATION_JSON))
				      .andExpect(MockMvcResultMatchers.status().isCreated());
			 
			 this.mockMvc.perform(MockMvcRequestBuilders.get("/pessoa"))
	          .andExpect(MockMvcResultMatchers.status().isOk())
	          .andDo(MockMvcResultHandlers.print());
	 }

	  @Test
	  public void getTesteTest(){
		  String teste = pessoaBusinessObject.getTeste();
		  assertEquals("Teste", teste);
	  }
	  
	  @Test
	  public void addPessoaTest(){
		  PessoaDTOEntrada pessoaDTOEntrada = new PessoaDTOEntrada();
		  pessoaDTOEntrada.setCidade("Belo Horizonte");
		  pessoaDTOEntrada.setEstado("MG");
		  pessoaDTOEntrada.setIdade(45);
		  pessoaDTOEntrada.setNome("Siqueira Campos");
		  pessoaDTOEntrada.setRegiao("sudeste");
		  pessoaDTOEntrada.setScore(50);
		  pessoaBusinessObject.addPessoa(pessoaDTOEntrada);
		  assertEquals("Belo Horizonte", pessoaDTOEntrada.getCidade());
	  }
	  
	  @Test
	  public void setDateTest(){
		  Pessoa pessoa = new Pessoa();
		  pessoa.setCidade("Belo Horizonte");
		  pessoa.setEstado("MG");
		  pessoa.setIdade(45);
		  pessoa.setNome("Siqueira Campos");
		  pessoa.setRegiao("sudeste");
		  pessoa = pessoaBusinessObject.setDate(pessoa);
		  assertNotNull(pessoa.getDataInclusao());
	  }
	
	  @Test
	  public void populatePessoaEntradaTest(){
		  PessoaDTOEntrada pessoaDTOEntrada = new PessoaDTOEntrada();
		  pessoaDTOEntrada.setCidade("Belo Horizonte");
		  pessoaDTOEntrada.setEstado("MG");
		  pessoaDTOEntrada.setIdade(45);
		  pessoaDTOEntrada.setNome("Siqueira Campos");
		  pessoaDTOEntrada.setRegiao("sudeste");
		  pessoaDTOEntrada.setScore(50);
		  Pessoa pessoa = pessoaBusinessObject.populatePessoaEntrada(pessoaDTOEntrada);
		  assertNotNull(pessoa);
	  }
	  
	  @Test
	  public void populatePessoaSaidaTest(){
		  Pessoa pessoa = new Pessoa();
		  pessoa.setCidade("Belo Horizonte");
		  pessoa.setEstado("MG");
		  pessoa.setIdade(45);
		  pessoa.setNome("Siqueira Campos");
		  pessoa.setRegiao("sudeste");
		  pessoa = pessoaBusinessObject.setDate(pessoa);
		  PessoaDTOSaida pessoaDTOSaida = pessoaBusinessObject.populatePessoaSaida(pessoa);
		  assertNotNull(pessoaDTOSaida);
	  }
	  
	  
	  @Test
	  public void populateAllPessoasSaidaTest(){
		  Pessoa pessoa = new Pessoa();
		  pessoa.setCidade("Belo Horizonte");
		  pessoa.setEstado("MG");
		  pessoa.setIdade(45);
		  pessoa.setNome("Siqueira Campos");
		  pessoa.setRegiao("sudeste");
		  PessoasDTOSaida pessoasDTOSaida = pessoaBusinessObject.populateAllPessoasSaida(pessoa) ;
		  assertNotNull(pessoasDTOSaida);
	  }
	  
	  
	  
	  @Test
	  public void getTesteControllerTest() throws Exception{
		  
		  this.mockMvc.perform(MockMvcRequestBuilders.get("/teste").content("Teste"))
          .andExpect(MockMvcResultMatchers.status().isOk())
          .andDo(MockMvcResultHandlers.print());
	  }
	  
	  
		 
		

}
