public class Candidate implements CsvSerializable {

    private String name;
    private int number;
    private String party;
    private int votes;

    public Candidate(String name, int number, String party) {
        this.name = name;
        this.number = number;
        this.party = party;
        this.votes = 0;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getParty() {
        return party;
    }

    public int getVotes() {
        return votes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return format();
    }

    public String format() {
        return "Name: " + name + "\n" +
                "Number: " + number + "\n" +
                "Party: " + party + "\n" +
                "Votes: " + votes;
    }

    @Override
    public String toCsvRow(String separator) {
        return name + separator + number + separator + party + separator + votes;
    }
}
