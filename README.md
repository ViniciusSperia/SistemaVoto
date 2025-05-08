# Sistema de Votação em Java (Console)

Um sistema de votação simples desenvolvido em Java, utilizando estruturas de dados como `Map` e `Set` para simular uma eleição no terminal. Permite cadastrar candidatos, votar por número com verificação por CPF, e visualizar resultados ordenados.

## Funcionalidades

- Cadastrar candidatos únicos (nome, número e partido)
- Permitir votação com verificação de CPF único
- Bloquear votos duplicados por CPF
- Exibir resultados ordenados por número de votos
- Listar todos os candidatos cadastrados
- Validação de entradas para evitar erros de digitação

## Tecnologias Utilizadas

- Java 17
- Console (entrada via `Scanner`)
- Estrutura com 3 classes principais:
    - `Candidato`
    - `SistemaVotacao`
    - `Main`

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/seuprojeto.git

2. Abra em uma IDE como IntelliJ ou Eclipse.

3. Execute a classe Main.java.

4. Use o menu interativo no console.

##  O que eu aprendi neste projeto
Organização de lógica em múltiplas classes

Utilização de HashMap<Integer, Integer> para contagem de votos

Utilização de HashSet<String> para controlar eleitores únicos

Boas práticas com Scanner, .trim(), equalsIgnoreCase()

Validação de entrada com try/catch e InputMismatchException

Separação de lógica de apresentação e negócio

##  Estrutura do Projeto
 ```bash
SistemaVotacao/
├── Main.java
├── Candidato.java
├── SistemaVotacao.java
````

##  Possíveis Melhorias Futuras
- Exportação dos resultados para .csv ou .json

- Integração com banco de dados

- Suporte a votos em branco ou nulos

##  Autor
- Desenvolvido por Vinicius Speria
- Contato: vinicius.speria.tech@gmail.com
- GitHub: https://github.com/ViniciusSperia