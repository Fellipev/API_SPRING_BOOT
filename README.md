# API_SPRING_BOOT
CRUD de usuários com SPRING BOOT, flyway, lombok e usando DTO.
No caminho resources/db/migration tem a criação do banco de dados, incluindo alguns testes que eu fiz para me familiarizar com o uso do flyway.

O GET, POST, PUT e DELETE. eu usei um banco localhost e o Insomnia, vou deixar aqui a url das requisições e 2 json de modelo:

POST
http://localhost:8080/usuarios
{
  "nome" : "Fulano",
	"email" : "fulano.silva@dev.ag",
	"crm" : "654321",
	"telefone" : "1199999999",
	"especialidade" : "FRONTEND",
	"endereco" : {
		"logradouro" : "rua x",
		"bairro" : "bairro z",
		"cep" : "12377778",
		"uf" : "SP",
		"cidade" : "São Paulo",
		"numero" : "20", //Dado não obrigratório
		"complemento" : "De frente com uma praça" //Dado não obrigratório
	}
}

GET
http://localhost:8080/usuarios

PUT
http://localhost:8080/usuarios
{
  "id" : 1,
  "nome" : "ciclano",
  "email" : "ciclano.silva@dev.ag",
  "telefone" : "1198888888",
  "endereco" : {
    "logradouro" : "rua y",
		"bairro" : "bairro x",
		"cep" : "12888778",
		"uf" : "MG",
		"cidade" : "Minas gerais",
		"numero" : "10", //Dado não obrigratório
		"complemento : "exemplro de complemento"//Dado não obrigratório
  }
}

No metodo PUT, eu não permiti que todos os campos pudessem ser atualizados como se fosse uma simulação de uma regra de negócios,
os campos que podem ser atualizados são estes listados no JSON acima.

DELETE
http://localhost:8080/usuarios/2
No método DELETE, o id a ser "deletado" é passado na url, no banco o usuário de mesmo id da url só sera inativado.
