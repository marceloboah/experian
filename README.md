# experian

# Instruções

</br>
Obs: O arquivo está configurado na porta 9099.
</br></br>
<font color="red">
Obs: Alguns endpoints foram atualizados por necessidade de ajustes no frontend, a documentação se encontra desatualizado por adições de id's em endpoints existentes e novos endpoints.
</font>
</br></br>
Os objetos possuem relacionamentos e devem ser inseridos na mesma sequencia sugerda na tarefa. Itens como Pessoa se estiverem sem relacionamento com Afinidade e Score não retornarão.
 </br>
 O sistema insere automáticamente a tabela sugerida na subida do servidor.
  </br> </br>
No core da tarefa, os itens relacionados a tarefas possuem testes unitários na camada de serviço conforme solicitado. Itens como Pessoa que dependem de outras tabelas foram testados na camada de controller para alguns casos específicos.
    </br> </br>
O item JWT feito posteriormente possuem itens dependentes como User e Login que não possuem testes por serem itens adidionais.
   
</br>
Após a implementação do JWT torna-se obrigatório o envio do parametro Authorization para todas as chamadas com a exceção da chamada de login abaixo. Como a base de dados está vazia a primeira autenticação é configurada no arquivo de application.properties. Seguem abaixo a chamda em formato cUrl para importar no Postman. 
</br> </br>

# Login
</br>
POST 'http://localhost:9099/authenticate'
</br>
{</br>
 "username": "marcelo",
 </br>
 "password": "usersecretforjwtauthenticateoratoroeuaroupadoreideromalalalameudeuscomoessabencaodechave"
 </br>
 }</br>
</br>
curl --location --request POST 'http://localhost:9099/authenticate' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=AAE8C84977575FE0630F1D0A81AC75A5' \
--data-raw '{
    "username": "marcelo",
    "password": "usersecretforjwtauthenticateoratoroeuaroupadoreideromalalalameudeuscomoessabencaodechave"
}'
 </br> </br>
 
O Token devolvido deve ser utilizado para as chamadas.
  </br> </br>
 # Afinidade
  </br> </br>
 curl --location --request POST 'http://localhost:9099/afinidade' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJjZWxvIiwiZXhwIjoxNjUxNDc0MDI1LCJpYXQiOjE2NTE0NTYwMjV9.qsXHwtFatrzzCnkTsRHs6fUB8KaHnLiZChC5NVRnqr6NFlWq5S7b33MAafr57K1X1IvncU7fjq5GjTVqhd7fLQ' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=AAE8C84977575FE0630F1D0A81AC75A5' \
--data-raw '{
	"regiao": "sudeste",
	"estados": [
		"SP", 
		"RJ", 
		"MG", 
		"ES"
	]
}'
 </br> </br>
# Pessoa
 </br> </br>
curl --location --request POST 'http://localhost:9099/pessoa' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJjZWxvIiwiZXhwIjoxNjUxMzg2NjY4LCJpYXQiOjE2NTEzNjg2Njh9.eWkNSRK6IpCkSOSdZRjuldjr7DWg62-pG_KySWQfQqI51pbv0MyrLShqpILNDsOH9ULTlT9D4Sw1JKWhK6fl2g' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=AAE8C84977575FE0630F1D0A81AC75A5' \
--data-raw '{
	"nome": "Fulano de Tal",
	"telefone": "99 99999-9999",
	"idade": 99,
	"cidade": "Cidade de Fulano",
	"estado": "XX",
	"score": 1000,		
	"regiao": "sudeste"
}'
 </br> </br>
curl --location --request GET 'http://localhost:9099/pessoa/1' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJjZWxvIiwiZXhwIjoxNjUxMzg2NjY4LCJpYXQiOjE2NTEzNjg2Njh9.eWkNSRK6IpCkSOSdZRjuldjr7DWg62-pG_KySWQfQqI51pbv0MyrLShqpILNDsOH9ULTlT9D4Sw1JKWhK6fl2g' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=AAE8C84977575FE0630F1D0A81AC75A5' \
--data-raw '
 </br> </br>
curl --location --request GET 'http://localhost:9099/pessoa' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJjZWxvIiwiZXhwIjoxNjUxMzg2NjY4LCJpYXQiOjE2NTEzNjg2Njh9.eWkNSRK6IpCkSOSdZRjuldjr7DWg62-pG_KySWQfQqI51pbv0MyrLShqpILNDsOH9ULTlT9D4Sw1JKWhK6fl2g' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=AAE8C84977575FE0630F1D0A81AC75A5' \
--data-raw '




## ---------------------------------------------------------------
# Desafio Serasa Experian 
</br></br>
# Objetivo: Criar um serviço do tipo API REST, para cadastro de pessoas com score e suas regiões de afinidades 

</br></br>
# 1.Para a construção desse serviço, algumas premissas e sugestões 
</br></br>
•	Usar linguagem Java (preferência Java 11); </br>
•	Usar maven no build do projeto; </br>
•	Pode criar archetype usando o start.spring.io (adicione as dependências que achar relevantes); </br>
•	Usar framework Spring (incluindo Spring Boot, para iniciar o serviço); </br>
•	Montar um banco de dados em memória (pode usar o H2, HSQLDB ou MongoDB), usando Hibernate na persistência de dados; </br>
•	Necessário pelo menos um teste unitário para cada método da camada Service, usando JUnit e Mockito; </br>
•	Colocar autenticação com token JWT (opcional) </br>
</br></br>
# 2.Endpoints do serviço 
</br></br>

•	POST /pessoa
 </br>
## Informar a seguinte estrutura de dados na inclusão:
</br></br>
{</br>
	“nome”: “Fulano de Tal”,</br>
	“telefone”: “99 99999-9999”,</br>
	“idade”: 99,</br>
	“cidade”: “Cidade de Fulano”,</br>
	“estado”: “XX”,</br>
	“score”: 1000,		// Entre 0 e 1000</br>
	“regiao”: “sudeste”</br>
}</br>
</br>
## Adicionar um atributo id automático e data de inclusão, além dos dados do POST, durante inclusão dos dados no banco;
## Retornar 201 no sucesso da inclusão;

 </br>
•	POST /afinidade
## Informar a seguinte estrutura de dados na inclusão:
{</br>
	“regiao”: “sudeste”,</br>
	“estados”: [</br>
		“SP”, </br>
		“RJ”, </br>
		“MG”, </br>
		“ES”</br>
	]</br>
}</br></br>
## Retornar 201 no sucesso da inclusão;

•	POST /score </br>
## Informar a seguinte estrutura de dados na inclusão:
{ </br>
	“scoreDescricao”: “Insuficiente”, </br>
	“inicial”: 0, </br>
	“final”: 200 </br>
} </br> </br>
## Retornar 201 no sucesso da inclusão;

•	GET /pessoa/{id} </br>
## Se id encontrado no banco, retornar a seguinte estrutura de dados:
{ </br>
	“nome”: “Fulano de Tal”, </br>
	“telefone”: “99 99999-9999”, </br>
	“idade”: 99, </br>
	“scoreDescricao”: “Recomendável”, </br>
	“estados”: [ </br>
		“SP”,  </br>
		“RJ”,  </br>
		“MG”,  </br>
		“ES” </br>
	] </br>
} </br> </br>
## Se id encontrado no banco, retornar 200, com a estrutura de dados;
## Se id não encontrado no banco, retornar 204 (no content);

•	GET /pessoa
## Retornar uma lista de todo o cadastro, sendo cada item da lista com a seguinte estrutura de dados:
[ </br>
	{ </br>
		“nome”: “Fulano de Tal”, </br>
		“cidade”: “Cidade de Fulano”, </br>
		“estado”: “XX”, </br>
		“scoreDescricao”: “Recomendável”, </br>
	“estados”: [ </br>
		“SP”,  </br>
		“RJ”,  </br>
		“MG”,  </br>
		“ES” </br>
	] </br>
	}, </br>
	{ </br>
		“nome”: “Sicrano de Tal”, </br>
		“cidade”: “Cidade de Sicrano”, </br>
		“estado”: “XX”, </br>
		“scoreDescricao”: “Insuficiente”, </br>
	“estados”: [ </br>
		“RS”,  </br>
		“PR”,  </br>
		“SC” </br>
	] </br>
	} </br>
] </br>
## Se algum cadastro encontrado no banco, retornar 200, com a estrutura JSON;
## Se nenhum item encontrado no banco, retornar 204 (no content);

# 3.Lógica do serviço
 </br> </br>
•	Montar lógica na camada Service, para associar a regiao da afinidade, com a regiao da pessoa, e retornar a lista de estados correspondentes à regiao. </br>
•	Montar lógica na camada Service, para retornar o atributo scoreDescricao, correspondente ao score encontrado entre inicial e final; </br>
•	Cadastrar via POST os seguintes dados na estrutura score: </br> </br>
scoreDescricao	inicial	final </br>
Insuficiente	0	200 </br>
Inaceitável	201	500 </br>
Aceitável	501	700 </br>
Recomendável	701	1000 </br>

 </br> </br>
# 4.Estrutura do Banco de dados 
 </br> </br>
•	pessoa </br>
o	id – numérico </br>
o	dataInclusao – data </br>
o	nome – texto </br>
o	telefone – texto </br>
o	idade – numérico </br>
o	cidade – texto </br>
o	estado – texto </br>
o	regiao  – texto </br>
 </br> </br>
•	afinidade </br>
o	regiao  – texto </br>
o	estados – lista </br>
 </br> </br>
•	score </br>
o	descricao  – texto </br>
o	inicial – numérico </br>
o	final – numérico </br>
 </br>

