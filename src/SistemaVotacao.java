import java.util.*;

public class SistemaVotacao {

    private ArrayList<Candidato> candidatesList;
    private Map<Integer, Integer> votes;
    private Set<String> votersVoted;


    public SistemaVotacao() {
        this.candidatesList = new ArrayList<>();
        this.votes = new HashMap<>();
        this.votersVoted = new HashSet<>();
    }

    public void adicionarCandidato(Candidato c) {
        for (Candidato existente : candidatesList) {
            if (existente.getNumber() == c.getNumber()) {
                System.out.println("Erro: já existe um candidato com esse número.");
                return;
            }
        }

        votes.put(c.getNumber(), 0);
        candidatesList.add(c);
        System.out.println("Candidato cadastrado com sucesso.");
    }

    public void listarTodos(){
        if (candidatesList.isEmpty()) {
            System.out.println("Nenhum candidato cadastrado.");
            return;
        }

        for (Candidato c : candidatesList) {
            System.out.println(c);
            System.out.println("---------------");
        }
    }

    public void registrarVoto(int number, String cpf) {
        if (votersVoted.contains(cpf)) {
            System.out.println("Erro: este CPF já votou. Voto duplicado não permitido.");
            return;
        }

        if (!votes.containsKey(number)) {
            System.out.println("Voto inválido. Nenhum candidato com esse número.");
            return;
        }

        int atual = votes.get(number);
        votes.put(number, atual + 1);
        votersVoted.add(cpf);
        System.out.println("Voto registrado com sucesso.");
    }

    public void exibirResultados() {
        if (votes.isEmpty()) {
            System.out.println("Nenhum voto registrado.");
            return;
        }

        System.out.println("Resultados da votação:");
        candidatesList.stream()
                .sorted((c1, c2) -> votes.get(c2.getNumber()) - votes.get(c1.getNumber()))
                .forEach(c -> {
                    int totalVotos = votes.get(c.getNumber());
                    System.out.println("Nome: " + c.getName());
                    System.out.println("Número: " + c.getNumber());
                    System.out.println("Partido: " + c.getParty());
                    System.out.println("Votos: " + totalVotos);
                    System.out.println("---------------");
                });
    }

}
