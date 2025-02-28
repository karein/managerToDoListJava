# Aula 1

## Maven

gerenciador de dependências
update-alternatives: a usar /usr/share/maven/bin/mvn para disponibilizar /usr/bin/mvn (mvn) em modo auto

# Aula 2 - Criando Estrutura Projeto

- Group: por convenção, se utiliza o nome da empresa de trás para frente
  EX: www.danieleleao.com.br -> br.com.danieleleao

- JAR: Gera um arquivo executável. Se consegue utilizar o próprio java para rodar o executável .jar, sem precisar de outro servidor.
- WAR: Mais utilizado para aplicações web, gera um arquivo para ser executado é necessário um container.

## Spring Boot

Apesar de criar uma plicação web, é possível usar o .jar pois ele tem um servidor embarcado dentro da aplicação. A usar o .jar ele já adiciona um container Tomcat para rodar a aplicação.

O Spring Boot se tornou muito popular pois, antes se tinha que fazer muitas configurações, e para subir um projeto spring com por exemplo spring framework, eram necessários muitos arquivos de configuração e muitas coisas para gerenciar. Com Spring Boot ele já tem as dependências que gerenciam essas configurações.

# Aula 3 - Entendendo Estrutura

Toda classe inicia com um package que é o pacote onde essa classe está inserida.

- @SpringBootApplication: define que a classe TodolistApplication é a classe inicial do projeto.

Por baixo dos panos, o springBoot coloca esse método main para executar a aplicação e quando ele faz o `SpringApplication.run(TodolistApplication.class, args);` passando o nome da classe, ele tem um Tomcat por trá para rodar a aplicação

# Aula 4 - Entendendo o que é Controller

- Controller: Utilizada para ser a camada entre a requisição e as demais camada. É quem recebe a requisição do usuário

@Controller vs @RestController

- Controller: Utilizado quando se quer criar por exemplo uma estrutura onde se tenha páginas, uma flexibilidade maior de retornar não só objetos
  RestController: Quando se está construindo uma API com conceitos de REST

Ao se trabalhar com a spring ou conceito se api, se tem sempre uma **classe** e dentro dela um **método** java
estrutura: <modificador> <tipo_retorno> <nome_metodo>(<parametros>){} -> public String primeiraMensagem(){}

Métodos de requisição HTTP

- GET: Buscar uma informação
- POST: Adicionar um dado/informação
- PUT: Alterar um dado/informação
- DELETE: Remover um dado
- PATCH: Alterar somente uma parte da info/dado

# Aula 5 - Funcionalidade de usuário

Nome da classe deve ser igual ao nome do arquivo.

O tipo **void** é usado quando não se quer ter retorno

Ao usar o **private** nos atributos, os mesmo não podem ser acessados por outras classes.
EX: ao definir-los como private no UserModel, o name não poderá ser acessado pelo `System.out.println(userModel.name);` do Controller

# Aula 6 - Getters e Setters

Ao definir os atributos de uma classe como private, se tem que informar como eles poderão ser acessados por outras classes. Dessa forma se usam os `getters` e `setters`

# Aula 7 - Lombok

Anotation `@Data` adiciona getters e setters em todos os atributos.
para add apenas os getters seria o `@Getter` e para o setter seria `@Setter`

# Aula 8 - Banco de dados

Spring Data JPA:

    - Um dos projetos do Spring onde se consegue fazer a comunicação com o banco de dados;
    - Camada de comunicação com o banco de dados;
    - Utiliza o conceito de ORM, quando se tem um objeto e quer transformar para uma forma que o banco de dados consiga enteder

H2 Database: Banco de dados em memória

# Referências

- Doc: https://efficient-sloth-d85.notion.site/Maven-d11762457beb4cf7a0ecc83e22f99991
- Entidade/Entity: Normalmente é um objeto que vai representar uma tabela
