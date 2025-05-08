public class Candidato {

    private String name;
    private int number;
    private String party;

    public Candidato(String name, int number, String party) {
        this.name = name;
        this.number = number;
        this.party = party;
    }


    public String getName(){
        return name;
    }
    public int getNumber(){
        return number;
    }
    public String getParty(){
        return party;
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

    @Override
    public String toString() {
        return format();
    }

    public String format() {
        return "Nome: " + name + "\n" +
                "Número: " + number + "\n" +
                "Partido: " + party;
    }

}
