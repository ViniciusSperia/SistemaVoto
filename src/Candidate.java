public class Candidate implements CsvSerializable {

    private int id; // Banco de dados usa como chave primária
    private String name;
    private int number;
    private String party;
    private int votes;

    public Candidate(int id, String name, int number, String party, int votes) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.party = party;
        this.votes = votes;
    }

    // Construtor alternativo útil para registros iniciais (sem ID ainda)
    public Candidate(String name, int number, String party) {
        this(0, name, number, party, 0);
    }

    // Getters
    public int getId() {
        return id;
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

    // Setters
    public void setId(int id) {
        this.id = id;
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

    // Para exibição no menu "Listar Candidatos"
    public String format() {
        return "Name: " + name + "\n" +
                "Number: " + number + "\n" +
                "Party: " + party;
    }

    @Override
    public String toString() {
        return format();
    }

    // Para exportação em CSV
    @Override
    public String toCsvRow(String separator) {
        return name + separator + number + separator + party + separator + votes;
    }
}
