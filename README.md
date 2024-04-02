## proposito

1. Feito para por em pratica conceitos visto na disciplina de padroes de projeto e de programcao web.

2. api de autenticacao, que dentro de um cenario de microservisses onde a mesma sera consumida por varias aplicacoes ela permite a geracao e validacao de tokens em diferentes formatos (ate entao so foi implementado o jwt) e diferentes formatos de usuarios conforme a aplicacao necessitar (login - login e senha - login, senha e cargo etc)

## Como funciona?

1. os endpoints de geracao de token variam conforme o formato do usuario ".../authetication/generateToken/(formato, por exemplo "Login" ou "LoginPassword")/{service}

2. usando do artificio da reflexao computacional o atributo da uri "service" corresponde ao nome da fabrica abstrata - classe - a ser instanciada

3. as abstract factorys reunem os servicos de token (gerar e validar) e os respectivos  modelos de usuarios associados

4. o endpoint de validacao e o mesmo para todos, variando apenas o atributo "service" ja mencionado acima

## Notas

1. ainda em fase de testagem

2. falta lapidar o codigo, o commit atual foi fruto de uma experimentacao com o springBoot, com padroes de projeto e reflexao computacional
