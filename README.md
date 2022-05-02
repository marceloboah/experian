# experian
# Instruções

</br>
Após a implementação do JWT torna-se obrigatório o envio do parametro Authorization para todas as chamadas com a exceção da chamada de login abaixo. Como a base de dados está vazia a primeira autenticação é configurada no arquivo de application.properties. Seguem abaixo a chamda em formato cUrl para importar no Postman.
</br>
Obs: O arquivo está configurado na porta 9099.
</br>
# Login:
POST 'http://localhost:9099/authenticate'
</br>
 "username": "marcelo",
 </br>
 "password": "usersecretforjwtauthenticateoratoroeuaroupadoreideromalalalameudeuscomoessabencaodechave"
 </br>

curl --location --request POST 'http://localhost:9099/authenticate' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=AAE8C84977575FE0630F1D0A81AC75A5' \
--data-raw '{
    "username": "marcelo",
    "password": "usersecretforjwtauthenticateoratoroeuaroupadoreideromalalalameudeuscomoessabencaodechave"
}'
 </br>
 
 
 
 

# ------------------------------------------------------------------------------------------------------------------------------
Objetivo: Criar um serviço do tipo API REST, para cadastro de pessoas com score e suas regiões de afinidades 
 </br>
# Para a construção desse serviço, algumas premissas e sugestões </br>

•	Usar linguagem Java (preferência Java 11); </br>
•	Usar maven no build do projeto; </br>
•	Pode criar archetype usando o start.spring.io (adicione as dependências que achar relevantes); </br>
•	Usar framework Spring (incluindo Spring Boot, para iniciar o serviço); </br>
•	Montar um banco de dados em memória (pode usar o H2, HSQLDB ou MongoDB), usando Hibernate na persistência de dados; </br>
•	Necessário pelo menos um teste unitário para cada método da camada Service, usando JUnit e Mockito; </br>
•	Colocar autenticação com token JWT (opcional) </br>

# Endpoints do serviço </br>

•	POST /pessoa
 </br>
# Informar a seguinte estrutura de dados na inclusão:
{
	“nome”: “Fulano de Tal”,
	“telefone”: “99 99999-9999”,
	“idade”: 99,
	“cidade”: “Cidade de Fulano”,
	“estado”: “XX”,
	“score”: 1000,		// Entre 0 e 1000
	“regiao”: “sudeste”
}
# Adicionar um atributo id automático e data de inclusão, além dos dados do POST, durante inclusão dos dados no banco;
# Retornar 201 no sucesso da inclusão;

 </br>
•	POST /afinidade
# Informar a seguinte estrutura de dados na inclusão:
{
	“regiao”: “sudeste”,
	“estados”: [
		“SP”, 
		“RJ”, 
		“MG”, 
		“ES”
	]
}
# Retornar 201 no sucesso da inclusão;

•	POST /score
# Informar a seguinte estrutura de dados na inclusão:
{
	“scoreDescricao”: “Insuficiente”,
	“inicial”: 0,
	“final”: 200
}
# Retornar 201 no sucesso da inclusão;

•	GET /pessoa/{id}
# Se id encontrado no banco, retornar a seguinte estrutura de dados:
{
	“nome”: “Fulano de Tal”,
	“telefone”: “99 99999-9999”,
	“idade”: 99,
	“scoreDescricao”: “Recomendável”,
	“estados”: [
		“SP”, 
		“RJ”, 
		“MG”, 
		“ES”
	]
}
# Se id encontrado no banco, retornar 200, com a estrutura de dados;
# Se id não encontrado no banco, retornar 204 (no content);

•	GET /pessoa
# Retornar uma lista de todo o cadastro, sendo cada item da lista com a seguinte estrutura de dados:
[
	{
		“nome”: “Fulano de Tal”,
		“cidade”: “Cidade de Fulano”,
		“estado”: “XX”,
		“scoreDescricao”: “Recomendável”,
	“estados”: [
		“SP”, 
		“RJ”, 
		“MG”, 
		“ES”
	]
	},
	{
		“nome”: “Sicrano de Tal”,
		“cidade”: “Cidade de Sicrano”,
		“estado”: “XX”,
		“scoreDescricao”: “Insuficiente”,
	“estados”: [
		“RS”, 
		“PR”, 
		“SC”
	]
	}
]
# Se algum cadastro encontrado no banco, retornar 200, com a estrutura JSON;
# Se nenhum item encontrado no banco, retornar 204 (no content);

3.	Lógica do serviço
 </br>
•	Montar lógica na camada Service, para associar a regiao da afinidade, com a regiao da pessoa, e retornar a lista de estados correspondentes à regiao. </br>
•	Montar lógica na camada Service, para retornar o atributo scoreDescricao, correspondente ao score encontrado entre inicial e final; </br>
•	Cadastrar via POST os seguintes dados na estrutura score: </br>
scoreDescricao	inicial	final </br>
Insuficiente	0	200 </br>
Inaceitável	201	500 </br>
Aceitável	501	700 </br>
Recomendável	701	1000 </br>


4.	Estrutura do Banco de dados </br>

•	pessoa </br>
o	id – numérico </br>
o	dataInclusao – data </br>
o	nome – texto </br>
o	telefone – texto </br>
o	idade – numérico </br>
o	cidade – texto </br>
o	estado – texto </br>
o	regiao  – texto </br>
 </br>
•	afinidade </br>
o	regiao  – texto </br>
o	estados – lista </br>
 </br>
•	score </br>
o	descricao  – texto </br>
o	inicial – numérico </br>
o	final – numérico </br>
 </br>

