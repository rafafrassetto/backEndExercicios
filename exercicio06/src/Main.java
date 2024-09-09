import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Que filme você deseja assistir?");
            List<Filme> filmes = cinema.getFilmesDisponiveis();
            for (int i = 0; i < filmes.size(); i++) {
                System.out.println((i + 1) + ". " + filmes.get(i).getNome());
            }

            int escolhaFilme;
            try {
                escolhaFilme = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                if (escolhaFilme < 1 || escolhaFilme > filmes.size()) {
                    System.out.println("Escolha inválida.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                scanner.nextLine(); // Limpar o buffer
                continue;
            }

            Filme filmeEscolhido = filmes.get(escolhaFilme - 1);

            System.out.println("Qual assento você deseja?");
            String assento = scanner.nextLine();

            System.out.println("Qual o seu nome?");
            String nome = scanner.nextLine();

            int idade;
            try {
                System.out.println("Qual a sua idade?");
                idade = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                scanner.nextLine(); // Limpar o buffer
                continue;
            }

            Cliente cliente = new Cliente(nome, idade);
            Ingresso ingresso = new Ingresso(cliente, filmeEscolhido, assento);

            try {
                cinema.venderIngresso(ingresso);
                System.out.println("Ingresso vendido com sucesso! " + filmeEscolhido.getNome() + " - " + assento + " - " + cliente.getNome());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}