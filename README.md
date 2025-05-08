# Voting System (Java + SQLite Console Application)

This project is a voting system built with Java and SQLite, designed for use via the console. It allows candidate registration, secure voting using unique IDs, and displays/export of voting results.

## Features

- Register candidates with name, number, and political party
- Prevent duplicate candidate numbers
- Vote using a unique voter ID (each ID can vote only once)
- Store all data in a local SQLite database
- Show results in descending order by number of votes
- Export results to a `.csv` file
- Input validation and basic error handling

## Technologies Used

- Java 17
- SQLite (via JDBC)
- SQL with auto-setup (`CREATE TABLE IF NOT EXISTS`)
- OOP with multiple classes:
  - `Main`
  - `Candidate`
  - `VotingSystem`
  - `CandidateRepository`
  - `VoteDAO`
  - `DatabaseConnection`
  - `DatabaseSetup`
  - `CsvExporter`
  - `CsvSerializable`

## How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/ViniciusSperia/voting-system.git
   ```

2. Open the project in a Java IDE (e.g., IntelliJ, Eclipse)

3. Run the `Main` class. The database will be initialized automatically.

4. Use the console menu to interact with the system.

## What I Learned in This Project

- Java object-oriented design
- JDBC and SQL integration (DDL, DML, connection handling)
- Transaction control and commit/rollback
- DAO and Repository patterns
- Input validation and exception handling
- CSV file generation and export
- Clear code organization and responsibility separation

## Project Structure

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

## Author

- Developer by Vinicius Speria
- Contact: [vinicius.speria.tech@gmail.com](mailto:vinicius.speria.tech@gmail.com)
- [github.com/ViniciusSperia](https://github.com/ViniciusSperia)
