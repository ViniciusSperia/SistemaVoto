# Sistema de Votação (Aplicação em Java via Console)

Este projeto é um sistema de votação simples desenvolvido em Java usando entrada via console. Ele permite cadastrar candidatos, votar utilizando um identificador único (como CPF), visualizar e exportar os resultados da eleição.

## Funcionalidades

- Cadastro de candidatos com nome, número e partido político
- Prevenção de números duplicados entre candidatos
- Votação com um ID único (cada ID só pode votar uma vez)
- Exibição de resultados em ordem decrescente por número de votos
- Exportação dos resultados para um arquivo `.csv`
- Validação de entrada e tratamento básico de erros

## Tecnologias Utilizadas

- Java 17
- Entrada/saída padrão com `Scanner`
- Estrutura orientada a objetos com múltiplas classes:

    - `Candidate`
    - `VotingSystem`
    - `CsvExporter`
    - `CsvSerializable`
    - `Main`

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/seuprojeto.git
   ```

2. Abra o projeto em uma IDE Java de sua preferência (como IntelliJ ou Eclipse)

3. Execute o arquivo `Main.java`

4. Use o menu interativo no console para interagir com o sistema

## O Que Eu Aprendi Neste Projeto

- Conceitos de programação orientada a objetos em Java
- Encapsulamento usando atributos privados e métodos públicos
- Uso de `ArrayList`, `Map` e `Set`
- Interfaces customizadas (`CsvSerializable`)
- Tratamento de exceções com `try/catch`
- Validação de entrada com `Scanner`
- Escrita em arquivos com `FileWriter`
- Separação de responsabilidades em classes distintas

## Estrutura do Projeto

- `Candidate`: representa um candidato com nome, número, partido e contagem de votos
- `VotingSystem`: lógica principal para cadastro, votação e exportação
- `CsvExporter`: gera arquivos CSV a partir dos dados dos candidatos
- `CsvSerializable`: interface que define a estrutura de serialização em CSV
- `Main`: ponto de entrada da aplicação e interação via console

## Autor

- Desenvolvido por Vinicius Speria
- Contato: vinicius.speria.tech@gmail.com
- GitHub: https://github.com/ViniciusSperia