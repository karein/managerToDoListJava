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

# Aula 9 - Criando Tabela Usuário

- Entidade/Entity: Normalmente é um objeto que vai representar uma tabela

# Aula 10 - Repository

Camada onde se tem os métodos utilizados para alterar/salvar etc os dados, se consegue fazer a comunicação com o banco de dados

- Interface: Um modelo dentro da aplicação, onde se tem os métodos mas não a implementação dos mesmos

JPA já tem alguns métodos definidos por padrão para se comunicar com o banco de dados
Quando existe o simbolo `<>` significa que a classe recebe um Generator

- Generator: Atributos dinâmicos
  EX: JpaRepository<Classe_que_o_repository_representa, Tipo_ID> -> JpaRepository<UserModel, UUID>

```java
//será passado como null pois não foi inicializado [com new]
private IUserRepository userRepository;
```

```java
//O Spring gerencia se precisa ou não inicializar o repository
@Autowired
private IUserRepository userRepository;
```

@Autowired: Spring gerencia o ciclo de vida

# Aula 11 - Validando username

Spring Data permite criar método apenas com `findBy<Nome_Atributo>`. Dessa forma ele já entende que tem que fazer um select com o atributo como referência
EX:findByUsername; findByName etc

# Aula 12 - Utilizando ResponseEntity

- ResponseEntity: Lida com as respostas permitindo gerenciar a resposta removendo a necessidade de criar vários objetos para diferentes situações de retorno

# Aula 13 - Hash da senha

- BCrypt: biblioteca para criptografar senha
  `.hashToString(<força_da_senha>, <senha_a_ser_criptografada>);`

# Aula 14 - Tabela de Task

Informações da tarefa:

    - ID
    - Usuário (ID_USUÁRIO)
    - Descrição
    - Título
    - Data Início
    - Data Término
    - prioridade

- @GeneratedValue: gera o Id automaticamente;
- @Column(length = 50): limita a quantidade de caracteres a 50

# Aula 15 - Cadastro de tarefa

- LocalDateTime estrutura: `yyyy-mm-ddTHH:mm:ss`

# Aula 16 - Realizando filtro

Tudo que se tem de web, Spring Boot e outros frameworks são baseados no **servelet** que é a base para qualquer framework web do java.

- @Component: Toda classe que será gerenciada pelo spring, deve ter essa anotação; a classe mais genérica de gerenciamento do spring

# Aula 17 - Continuando a Implementação do Filtro

`implements Filter` trocado por `extends OncePerRequestFilter` pois, ao utilizar o filtro do servelet, ele vai fornecer apenas um servelet request porém, ao se trabalhar com uma construção de api, requisições via HTTP/ comunicação via REST [daria ae pra fazer mas] teria que converter todos os _serveletRequest_ e _serveletResponse_ para _HTTPServeletRequest_ e _HttpServeletResponse_. Como o **OncePerRequestFilter** já tem isso é mais fácil trabalhar com ele.

Fluxo do filter:

    - Pegar a autenticação
    - Validar usuário
    - Validar senha
    - segue viagem

# Aula 18 - Validando rota

realizar filtro para uma rota específica
`if (serveletPath.equals("/tasks/"))`

# Aula 24 - Update Parcial

- BeanWrapper: Classe do Java; Interface que fornece uma forma de acessar as propriedade de um objeto no java
- BeanWrapperImpl: Implementação da interface BeanWrapper

- Static: Ao usar o static, não se precisa instanciar a classe

# Aula 26 - Try catch

Exceções tratáveis: ocasionada pelo usuário; erro de dados; erro de validação [Exception]
Exceções não tratáveis: ocasionada pelo sistema (ex: quando o sistema esta fora do ar)

não foi add o try catch no taskController pois no model está utilizando não somente o lombok mas principalmentee o RequestBody que por baixo dos panos faz o por baixo dos panos faz o set no momento que se acessa o create, não se consegue facilmente nível de método recuperar a exceção.

- @ControllerAdvice: Uma anotação do spring usada para definir classes globais no momento e tratamento de exceções

# Aula - Live reload

rodar projeto com comando: mvn spring-boot:run

# Aula - Deploy

render.com - ambiente gratuito

-- vai construir uma imagem da aplicação no render. Imagem inicial ubuntu
`FROM ubuntu:latest AS build`

-- atualizar bibliotecas e instalar java 17
-- -y -> informar sim para todas as perguntas

```Dockerfile
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
```

-- copoa todo o conteudo do diretório da imagen ques está sendo contruida
`COPY . .`

-- instala o maven e cria 2 arquivos na pasta target, o .jar e o .jar.original. Os arquivos são nomeados de acordo com o <version>(**não do <parent>**) informado no pom.xml Ex: <version>0.0.1-SNAPSHOT</version>
RUN apt-get install maven -y
RUN mvn clean install

-- imagem base para rodar a aplicação
FROM openjdk:17-jdk-slim

-- expões a porta 8080 da aplicação
EXPOSE 8080

-- copia o arquivo.jar para o app no render
COPY --from=build /target/todolist-1.0.0.jar app.jar

-- executa os comandos pois por padrão ao se executar uma aplicação .jar, para conseguir executar ela pela linha de comando, se executa esses comandos. Ex: java -jar target/todolist-1.0.0.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

# Referências

- Doc: https://efficient-sloth-d85.notion.site/Maven-d11762457beb4cf7a0ecc83e22f99991
