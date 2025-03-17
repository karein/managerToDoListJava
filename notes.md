# Aula - Configurando o ambiente

## Maven

O Maven é um gerenciador de dependências para projetos Java. Ele facilita a inclusão de bibliotecas externas, o controle de versões e o gerenciamento de builds.

- update-alternatives: No Linux, o Maven pode ser configurado com o comando `update-alternatives`. Ele permite configurar qual versão do Maven será usada no sistema. Por exemplo, ao rodar o comando, você define que o Maven será acessado por meio do caminho /usr/share/maven/bin/mvn e disponível como /usr/bin/mvn no terminal em modo automático.

# Aula - Criando Estrutura Projeto

Quando estamos criando um projeto Java, é importante seguir algumas convenções para garantir que o código seja bem organizado e compreensível por outras pessoas.

- **Group**: Por convenção, utiliza-se o nome do domínio da empresa, mas de forma invertida. Isso ajuda a garantir que os nomes dos grupos sejam únicos e sigam a mesma lógica de organização. Por exemplo:

  - Se o domínio da empresa for www.danieleleao.com.br, o Group ID seria: br.com.danieleleao

- **JAR (Java ARchive)**: É um formato de arquivo compactado usado para distribuir aplicações Java. Um arquivo JAR é **executável**, ou seja, você pode rodá-lo diretamente com o comando java -jar, sem precisar de um servidor externo.
- **WAR (Web ARchive)**:É um formato utilizado para aplicações web. Ao contrário do JAR, um arquivo WAR **não é executável diretamente**. Para rodar uma aplicação WAR, é necessário um **container** de servlets, como o Apache Tomcat, que é responsável por gerenciar e executar a aplicação.

## Spring Boot

O Spring Boot é uma ferramenta que simplifica a criação de aplicações Java, principalmente aplicações web.

- Servidor Embutido: Uma das principais vantagens do Spring Boot é que ele permite que você crie um arquivo JAR executável com um servidor embutido (como o Tomcat), ou seja, você não precisa configurar um servidor externo para rodar sua aplicação. Basta rodar o arquivo .jar e o servidor já está lá, pronto para executar a aplicação.

- Por que o Spring Boot é popular? Antes do Spring Boot, criar uma aplicação web com o Spring Framework exigia muita configuração manual. Havia vários arquivos de configuração para definir dependências, integrar componentes e configurar o servidor. O Spring Boot automatiza grande parte dessas configurações, fornecendo dependências padrão e uma estrutura já pronta.

# Aula - Entendendo Estrutura

Toda classe inicia com um package que é o pacote onde essa classe está inserida.

- `@SpringBootApplication`: Anotação é utilizada para marcar a classe principal da aplicação. Define por exemplo, que a classe TodolistApplication, é o ponto de entrada do projeto.

- **Funcionamento Interno**: Por baixo dos panos, o Spring Boot automaticamente gera o método main() na sua classe principal, que chama SpringApplication.run(TodolistApplication.class, args);`. Esse método é responsável por inicializar o contexto do Spring, bem como iniciar o servidor embutido (geralmente Tomcat), responsável por executar a aplicação.

# Aula - Entendendo o que é Controller

- Controller: Utilizada para ser a camada entre a requisição e as demais camada. Ele é responsável por receber as requisições HTTP e retornar as respostas adequadas.

**@Controller X @RestController**

- **@Controller**: Utilizado quando você deseja criar uma aplicação web tradicional com Spring, onde pode haver renderização de páginas. uma flexibilidade maior de retornar de retornar uma página web (como um arquivo .html) além de objetos e dados.

- **@RestController**:é um controlador especial usado para serviços RESTFul e o equivalente a @Controller + @ResponseBody. Usado quando se está construindo uma API com conceitos de REST.

Ao se trabalhar com a spring ou conceito se api, se tem sempre uma **classe** e dentro dela um **método** java.

Estrutura do método:

```java
  <modificador> <tipo_retorno> <nome_metodo>(<parametros>){
    // corpo do método
  }
```

Exemplo do método:

```java
  public String primeiraMensagem(){}
```

Métodos de requisição HTTP

- GET: Buscar uma informação
- POST: Adicionar um dado/informação
- PUT: Alterar um dado/informação
- DELETE: Remover um dado
- PATCH: Alterar somente uma parte da info/dado

# Aula - Funcionalidade de usuário

Ao criar classes em Java, algumas convenções e boas práticas ajudam a manter o código organizado e compreensível.

- **Nome da classe e do arquivo**: Por convenção, o nome da classe deve ser igual ao nome do arquivo. Por exemplo, em uma classe chamada UserModel, o arquivo deverá se chamar UserModel.java.

- **Tipo** `void`: O tipo void é utilizado quando um método não retorna nenhum valor. Ou seja, o método executa uma ação, mas não fornece um valor de volta. Por exemplo:

```
public void saveUser(User user) {}
```

- **Modificador private**: Ao usar o **private** nos atributos, os mesmo não podem ser acessados por outras classes. Por exemplo:

```java
public class UserModel {
    private String name;

    // Não é possível acessar diretamente em outra classe etc
    // System.out.println(userModel.name); // Vai gerar erro
}
```

# Aula - Getters e Setters

Ao definir os atributos de uma classe como private, se tem que informar como eles poderão ser acessados por outras classes. Isso é feito através dos `getters` e `setters`

- **Getter**: É o método que permite acessar o valor de um atributo private
- **Setter**: É o método utilizado para modificar o valor de um atributo private.

```java
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
```

# Aula - Lombok

O Lombok é uma biblioteca que reduz a quantidade de código em Java, facilitando a criação de métodos repetitivos como getters, setters, toString(), entre outros.

- `@Data`: A anotação @Data gera automaticamente getters, setters para todos os atributos da classe. Ao usar essa anotação, você não precisa escrever manualmente os métodos.  
  Para gerar apenas os getters ou setters individualmente, pode usar essas anotações específicas `@Getter` e `@Setter`.

# Aula 8 - Banco de dados

**Spring Data JPA**:

- facilita a comunicação entre a aplicação e o banco de dados, utilizando o conceito de ORM (Object-Relational Mapping)
- Se pode trabalhar com objetos Java e o JPA (Java Persistence API) se encarrega de transformar esses objetos em um formato que o banco de dados entenda
- Um dos projetos do Spring onde se consegue fazer a comunicação com o banco de dados;
- Camada de comunicação com o banco de dados;
- Utiliza o conceito de ORM (Object-Relational Mapping), quando se tem um objeto e quer transformar para uma forma que o banco de dados consiga entender.

**H2 Database**: Banco de dados relacional utilizado principalmente em cenários de desenvolvimento e teste devido à sua facilidade de configuração. funciona em memória, o que significa que o H2 pode ser configurado para manter os dados apenas durante a execução da aplicação, ou seja, os dados são armazenados temporariamente e perdidos quando a aplicação é desligada.

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
