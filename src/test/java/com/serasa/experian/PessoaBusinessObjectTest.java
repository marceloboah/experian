package com.serasa.experian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.serasa.business.PessoaBusinessObject;
import com.serasa.domain.Pessoa;
import com.serasa.dto.PessoaDTOEntrada;
import com.serasa.dto.PessoaDTOSaida;
import com.serasa.dto.PessoasDTOSaida;

@RunWith(SpringRunner.class)
@SpringBootTest 
@AutoConfigureMockMvc
public class PessoaBusinessObjectTest {
	
	  @Autowired
	  private PessoaBusinessObject pessoaBusinessObject;

	  /*@Test
	  void getPessoaByIdTest(){
		  PessoaDTOSaida pessoa = pessoaBusinessObject.getPessoaById(1L);
		  if(pessoa != null) {
			  assertNotNull(pessoa);
		  }else {
			  assertNull(pessoa);
		  }
		  //assertEquals(pessoa, pessoa);
	  }
	  
	  @Test
	  void getPessoasTest(){
		  List<PessoasDTOSaida> listPessoas = pessoaBusinessObject.getPessoas();
		  if(listPessoas != null) {
			  assertNotNull(listPessoas);
		  }else {
			  assertNull(listPessoas);
		  }
		  //assertEquals(listPessoas, listPessoas);
	  }*/

	  @Test
	  void getTesteTest(){
		  String teste = pessoaBusinessObject.getTeste();
		  assertEquals("Teste", teste);
	  }
	  
	  @Test
	  void addPessoaTest(){
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
	  void setDateTest(){
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
	  void populatePessoaEntradaTest(){
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
	  void populatePessoaSaidaTest(){
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
	  void populateAllPessoasSaidaTest(){
		  Pessoa pessoa = new Pessoa();
		  pessoa.setCidade("Belo Horizonte");
		  pessoa.setEstado("MG");
		  pessoa.setIdade(45);
		  pessoa.setNome("Siqueira Campos");
		  pessoa.setRegiao("sudeste");
		  PessoasDTOSaida pessoasDTOSaida = pessoaBusinessObject.populateAllPessoasSaida(pessoa) ;
		  assertNotNull(pessoasDTOSaida);
	  }

}
