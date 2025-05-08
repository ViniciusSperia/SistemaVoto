import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in); // Cria objeto Scanner para leitura do teclado

        SistemaVotacao sv = new SistemaVotacao();

        int opcao = -1;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar candidato");
            System.out.println("2 - Votar");
            System.out.println("3 - Mostrar resultados");
            System.out.println("4 - Listar Candidatos");
            System.out.println("0 - Sair");

            try {
                System.out.print("Digite sua opção: ");
                opcao = entrada.nextInt();
                entrada.nextLine(); // limpa buffer
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Certifique-se de digitar apenas números.");
                entrada.nextLine(); // limpa o lixo que ficou no buffer
                opcao = -1; // volta para o início do loop
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome do candidato: ");
                    String name = entrada.nextLine().trim();

                    System.out.print("Partido: ");
                    String party = entrada.nextLine().trim();

                    try {
                        System.out.print("Número: ");
                        int number = entrada.nextInt();

                        Candidato candidate = new Candidato(name, number, party);
                        sv.adicionarCandidato(candidate);
                    } catch (InputMismatchException e) {
                        System.out.println("Erro:  devem ser números.");
                        entrada.nextLine(); // limpa buffer
                    }
                    break;
                case 2:
                    System.out.print("Digite seu CPF: ");
                    String cpf = entrada.nextLine().trim();

                    try {
                        System.out.print("Digite o número do candidato: ");
                        int numeroVoto = entrada.nextInt();
                        entrada.nextLine(); // limpa o buffer
                        sv.registrarVoto(numeroVoto, cpf);
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: o número do candidato deve ser um número inteiro.");
                        entrada.nextLine(); // limpa buffer
                    }
                    break;
                case 3:
                    sv.exibirResultados();
                    break;
                case 4:
                    sv.listarTodos();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0); // Condição correta para manter o menu

        entrada.close(); // Libera recurso do Scanner
    }
}