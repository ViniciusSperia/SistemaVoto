
# Sistema de Votação (Aplicação Java + SQLite via Console)

Este projeto é um sistema de votação desenvolvido em Java com persistência em SQLite e entrada via console. Permite registrar candidatos, votar usando um identificador único (CPF) e visualizar/exportar os resultados da eleição.

## Funcionalidades

- Cadastro de candidatos com nome, número e partido político
- Prevenção de números duplicados para candidatos
- Votação com CPF único (cada CPF pode votar apenas uma vez)
- Armazenamento dos dados em banco SQLite local
- Exibição dos resultados ordenados por número de votos
- Exportação dos resultados em arquivo `.csv`
- Validação de entradas e tratamento básico de erros

## Tecnologias Utilizadas

- Java 17
- SQLite (JDBC)
- SQL com criação automática de tabelas (`CREATE TABLE IF NOT EXISTS`)
- Estrutura orientada a objetos com múltiplas classes:
  - `Main`
  - `Candidate`
  - `VotingSystem`
  - `CandidateRepository`
  - `VoteDAO`
  - `DatabaseConnection`
  - `DatabaseSetup`
  - `CsvExporter`
  - `CsvSerializable`

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/ViniciusSperia/voting-system.git
   ```

2. Abra o projeto em uma IDE Java (IntelliJ, Eclipse etc.)

3. Execute a classe `Main`. O banco será inicializado automaticamente.

4. Use o menu do console para interagir com o sistema.

## O Que Eu Aprendi Neste Projeto

- Conceitos de orientação a objetos em Java
- Integração com banco de dados via JDBC e SQL
- Controle de transações (commit/rollback)
- Padrões DAO e Repository
- Validação de entrada e tratamento de exceções
- Exportação de dados para CSV
- Separação clara de responsabilidades entre classes

## Estrutura do Projeto

```
VotingSystem/
├── Main.java
├── Candidate.java
├── VotingSystem.java
├── CandidateRepository.java
├── VoteDAO.java
├── DatabaseConnection.java
├── DatabaseSetup.java
├── CsvExporter.java
├── CsvSerializable.java
└── database/
    └── voting.sqlite
```

## Autor

- Desenvolvido por Vinicius Speria
- Contato: [vinicius.speria.tech@gmail.com](mailto:vinicius.speria.tech@gmail.com)
- [github.com/ViniciusSperia](https://github.com/ViniciusSperia)
