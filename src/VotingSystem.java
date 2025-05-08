import java.io.IOException;
import java.util.*;

public class VotingSystem {

    private final List<Candidate> candidateList;
    private final Map<Integer, Integer> votes;
    private final Set<String> registeredVoters;

    public VotingSystem() {
        this.candidateList = new ArrayList<>();
        this.votes = new HashMap<>();
        this.registeredVoters = new HashSet<>();
    }

    public void registerCandidate(Candidate c) {
        for (Candidate existing : candidateList) {
            if (existing.getNumber() == c.getNumber()) {
                System.out.println("Error: A candidate with this number already exists.");
                return;
            }
        }

        votes.put(c.getNumber(), 0);
        candidateList.add(c);
        System.out.println("Candidate registered successfully.");
    }

    public void listCandidates() {
        if (candidateList.isEmpty()) {
            System.out.println("No candidates registered.");
            return;
        }

        for (Candidate c : candidateList) {
            System.out.println(c);
            System.out.println("---------------");
        }
    }

    public void registerVote(int number, String cpf) {
        if (registeredVoters.contains(cpf)) {
            System.out.println("You have already voted. Duplicate votes are not allowed.");
            return;
        }

        if (!votes.containsKey(number)) {
            System.out.println("Invalid vote. No candidate with that number.");
            return;
        }

        int current = votes.get(number);
        votes.put(number, current + 1);
        registeredVoters.add(cpf);
        System.out.println("Vote registered successfully.");
    }

    public void displayResults() {
        if (votes.isEmpty()) {
            System.out.println("No votes have been registered.");
            return;
        }

        System.out.println("Voting Results:");
        candidateList.stream()
                .sorted((c1, c2) -> votes.get(c2.getNumber()) - votes.get(c1.getNumber()))
                .forEach(c -> {
                    int totalVotes = votes.get(c.getNumber());
                    System.out.println("Name: " + c.getName());
                    System.out.println("Number: " + c.getNumber());
                    System.out.println("Party: " + c.getParty());
                    System.out.println("Votes: " + totalVotes);
                    System.out.println("---------------");
                });
    }

    public void exportResultsToCsv(String filePath) {
        for (Candidate c : candidateList) {
            int count = votes.getOrDefault(c.getNumber(), 0);
            c.setVotes(count);
        }

        try {
            CsvExporter.export(candidateList, filePath, ";", CsvSerializable.csvHeader(";"));
            System.out.println("CSV export completed successfully.");
        } catch (IOException e) {
            System.out.println("Export failed: " + e.getMessage());
        }
    }
}
