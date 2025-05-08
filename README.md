# Voting System (Java Console Application)

This project is a simple voting system developed in Java using console input. It allows users to register candidates, vote using a unique voter ID (e.g., CPF), and view or export the election results.


## Features

- Register candidates with name, number, and political party
- Prevent duplicate candidate numbers
- Vote using a unique voter ID (each ID can vote only once)
- Show results in descending order by number of votes
- Export results to a .csv file
- Input validation and basic error handling

## Technologies Used

- Java 17

- Standard input/output with `Scanner`

- Object-oriented structure with multiple classes:

  - `Candidate`

  - `VotingSystem`

  - `CsvExporter`

  - `CsvSerializable`

  - `Main`

## How to Run

1. Clone the repository.
   ```bash
   git clone https://github.com/seuusuario/seuprojeto.git

2. Open the project in your preferred Java IDE (e.g., IntelliJ, Eclipse).

3. Run Main.java.

4. Use the console menu to interact with the system.

##  What I Learned in This Project

- Java object-oriented programming concepts

- Encapsulation using private attributes and public methods

- Working with ArrayList, Map, and Set

- Custom interfaces (CsvSerializable)

- Error handling with try/catch

- Input validation with Scanner

- Basic file writing using FileWriter

- Separation of responsibilities across classes

## Project Structure

- `Candidate`: Represents a candidate with name, number, party, and vote count.
- `VotingSystem`: Core logic for registering candidates, votes, and exporting results.
- `CsvExporter`: Handles CSV file generation from candidate data.
- `CsvSerializable`: Interface defining a contract for CSV serialization.
- `Main`: Console-based user interaction and application entry point.


##  Author

- Developer by Vinicius Speria
- Contact: vinicius.speria.tech@gmail.com
- GitHub: https://github.com/ViniciusSperia
