import java.util.List;

public class VotingSystem {

    private final CandidateRepository candidateRepository;
    private final VoteRepository voteRepository;

    public VotingSystem() {
        this.candidateRepository = new CandidateRepository();
        this.voteRepository = new VoteRepository();
    }

    public void registerCandidate(Candidate candidate) {
        if (candidateRepository.existsByNumber(candidate.getNumber())) {
            System.out.println("Error: A candidate with this number already exists.");
            return;
        }

        if (candidateRepository.save(candidate)) {
            System.out.println("Candidate registered successfully.");
        } else {
            System.out.println("Failed to register candidate.");
        }
    }

    public void listCandidates() {
        List<Candidate> candidates = candidateRepository.findAll();

        if (candidates.isEmpty()) {
            System.out.println("No candidates registered.");
            return;
        }

        for (Candidate c : candidates) {
            System.out.println(c);
            System.out.println("---------------");
        }
    }

    public void registerVote(int number, String voterId) {
        if (voteRepository.hasAlreadyVoted(voterId)) {
            System.out.println("You have already voted. Duplicate votes are not allowed.");
            return;
        }

        Candidate candidate = candidateRepository.findByNumber(number);
        if (candidate == null) {
            System.out.println("Invalid vote. No candidate with that number.");
            return;
        }

        // 1. Registra o voto
        boolean voteSaved = voteRepository.registerVote(number, voterId);

        // 2. Atualiza a contagem de votos no banco
        if (voteSaved) {
            int updatedVotes = candidate.getVotes() + 1;
            boolean updated = candidateRepository.updateVotes(number, updatedVotes);
            if (updated) {
                System.out.println("Vote registered successfully.");
            } else {
                System.out.println("Vote was saved, but failed to update candidate count.");
            }
        } else {
            System.out.println("Failed to register vote.");
        }
    }

    public void displayResults() {
        List<Candidate> candidates = candidateRepository.findAll();

        if (candidates.isEmpty()) {
            System.out.println("No votes have been registered.");
            return;
        }

        candidates.stream()
                .sorted((c1, c2) -> Integer.compare(c2.getVotes(), c1.getVotes()))
                .forEach(c -> {
                    System.out.println("Name: " + c.getName());
                    System.out.println("Number: " + c.getNumber());
                    System.out.println("Party: " + c.getParty());
                    System.out.println("Votes: " + c.getVotes());
                    System.out.println("---------------");
                });
    }

    public void exportResultsToCsv(String filePath) {
        List<Candidate> candidates = candidateRepository.findAll();

        try {
            CsvExporter.export(candidates, filePath, ";", CsvSerializable.csvHeader(";"));
            System.out.println("CSV export completed successfully.");
        } catch (Exception e) {
            System.out.println("Export failed: " + e.getMessage());
        }
    }
}
