import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creates scanner object for keyboard input

        VotingSystem votingSystem = new VotingSystem();

        int option = -1;

        do {
            System.out.println("1 - Register candidate");
            System.out.println("2 - Vote");
            System.out.println("3 - Show results");
            System.out.println("4 - List candidates");
            System.out.println("5 - Export results to CSV");
            System.out.println("0 - Exit");

            try {
                System.out.print("Enter your option: ");
                option = scanner.nextInt();
                scanner.nextLine(); // Clears input buffer
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                scanner.nextLine(); // Clears leftover invalid input
                option = -1;
            }

            switch (option) {
                case 1:
                    System.out.print("Candidate name: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Political party: ");
                    String party = scanner.nextLine().trim();

                    try {
                        System.out.print("Candidate number: ");
                        int number = scanner.nextInt();

                        Candidate candidate = new Candidate(name, number, party);
                        votingSystem.registerCandidate(candidate);
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Candidate number must be a valid integer.");
                        scanner.nextLine(); // Clears buffer
                    }
                    break;

                case 2:
                    System.out.print("Enter your ID (CPF): ");
                    String voterId = scanner.nextLine().trim();

                    try {
                        System.out.print("Enter candidate number: ");
                        int voteNumber = scanner.nextInt();
                        scanner.nextLine(); // Clears buffer

                        votingSystem.registerVote(voteNumber, voterId);
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Candidate number must be an integer.");
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    votingSystem.displayResults();
                    break;

                case 4:
                    votingSystem.listCandidates();
                    break;

                case 5:
                    votingSystem.exportResultsToCsv("results.csv");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 0);

        scanner.close();
    }
}
