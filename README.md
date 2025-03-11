# Todo List - Backend em Java

Este é um projeto backend de uma aplicação de lista de tarefas (To-Do List) implementado em **Java**. O projeto é construído utilizando o **Spring Boot**, **Maven** e o **banco de dados H2** para armazenamento local. A aplicação pode ser executada localmente ou implementada em uma plataforma de deploy como o _Render.com_.

## Pré-requisitos

Versões utilizadas:

- [Java 17](https://adoptopenjdk.net/) ou superior.
- [Maven 3.6.3](https://maven.apache.org/install.html) ou superior.

Editor Utilizado:

- [VS Code](https://code.visualstudio.com/) (opcional, se você preferir optar por outro editor).

## Como rodar o projeto

Existem diferentes formas de rodar o projeto:

### 1. Usando o comando `java -jar`

1. Primeiro, construa o projeto usando Maven:
   ```bash
   mvn clean install
   ```
2. Depois, rode a aplicação:
   ```bash
   java -jar target/<nome-do-projeto>.jar
   ```

### 2. Usando o comando Maven `spring-boot:run`

Outra forma de rodar a aplicação diretamente é utilizando o comando Maven:

```bash
mvn spring-boot:run
```

### 3. Usando o VS Code

Você também pode rodar o projeto diretamente pelo VS Code, com o plugin do Java configurado. Basta abrir o projeto no VS Code e rodar o arquivo Application.java ou usar a opção de "Run" no próprio editor.

## Banco de Dados

Este projeto utiliza o banco de dados H2 para armazenamento local das tarefas. O banco de dados é embutido e não requer configuração adicional.

### Configuração do H2

O banco de dados é acessado localmente através de uma URL jdbc:h2:mem:<nome_banco>, o que significa que ele é mantido em memória e será resetado toda vez que o servidor for reiniciado.

## Estrutura do Projeto

- `src/main/java`: Código-fonte do projeto.
- `src/main/resources`: Arquivos de configuração, como o _application.properties_.
- `pom.xml`: Arquivo de configuração do Maven, com as dependências do projeto.

## Deploy

O projeto pode ser facilmente implantado em plataformas como o Render.com, seguindo as recomendações da plataforma
