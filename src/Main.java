import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseSetup.initialize();


        VotingSystem votingSystem = new VotingSystem();
        int option = -1;

        do {
            System.out.println("\n1 - Register candidate");
            System.out.println("2 - Vote");
            System.out.println("3 - Show results");
            System.out.println("4 - List candidates");
            System.out.println("5 - Export results to CSV");
            System.out.println("0 - Exit");

            try {
                System.out.print("Enter your option: ");
                option = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                scanner.nextLine();
                continue;
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
                        scanner.nextLine();

                        Candidate candidate = new Candidate(name, number, party);
                        votingSystem.registerCandidate(candidate);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid number.");
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    System.out.print("Voter ID (CPF): ");
                    String cpf = scanner.nextLine().trim();

                    try {
                        System.out.print("Candidate number: ");
                        int voteNumber = scanner.nextInt();
                        scanner.nextLine();

                        votingSystem.registerVote(voteNumber, cpf);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid number.");
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
