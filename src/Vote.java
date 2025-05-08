public class Vote {
    private int id; // Optional: auto-incremented in database
    private int candidateNumber;
    private String voterId;

    public Vote(int candidateNumber, String voterId) {
        this.candidateNumber = candidateNumber;
        this.voterId = voterId;
    }

    public Vote(int id, int candidateNumber, String voterId) {
        this.id = id;
        this.candidateNumber = candidateNumber;
        this.voterId = voterId;
    }

    public int getId() {
        return id;
    }

    public int getCandidateNumber() {
        return candidateNumber;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setId(int id) {
        this.id = id;

    }

    public void setCandidateNumber(int candidateNumber) {
        this.candidateNumber = candidateNumber;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }
}
