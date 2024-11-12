# Projeto Biblioteca em Kotlin

Este projeto é uma aplicação simples de biblioteca desenvolvida em Kotlin, que permite adicionar, remover, emprestar, devolver livros e listar os livros disponíveis. Também inclui testes unitários utilizando o framework Kotest.

## Alunos

- João Lucas Gonçalves de Souza
- Lucas Mendes Ribeiro do Couto
- Natacha Calixto Garcia Ribeiro
- Pedro Guilherme Fernandes Oliveira


### Tecnologias Utilizadas
- **Kotlin**: Linguagem de programação principal.
- **Maven**: Gerenciamento de dependências e automação de build.
- **Kotest**: Framework para testes unitários.

## Requisitos
- Java JDK 20
- Maven instalado
- IntelliJ IDEA (recomendado para desenvolvimento)

## Instalação e Execução

1. Clone o repositório e vá até o diretório do projeto:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   ```

2. Instalar as Dependências:
   ```bash
   mvn clean install
   ```

3. Executar o Projeto:
   ```bash
   mvn test
   ```

## Configuração do Ambiente de Desenvolvimento (IntelliJ IDEA)
- Abra o **IntelliJ IDEA** e selecione **File > Open** e escolha o diretório do projeto clonado.
- O IntelliJ reconhecerá o `pom.xml` e configurará automaticamente o projeto.
- Para rodar os testes, abra a classe `LibraryTest` e clique no botão de execução ao lado de cada teste, ou execute `mvn test` diretamente no terminal da IDE.
