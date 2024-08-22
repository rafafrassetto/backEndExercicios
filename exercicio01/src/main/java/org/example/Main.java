package org.example;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Definição das recomendações
        String[] scifiComedia = { "Homens de Preto", "Guardiões da Galáxia", "Shrek", "De Volta Para o Futuro" };
        String[] scifiDrama = { "Arrival", "Interestelar", "Blade Runner", "A Chegada" };
        String[] medievalComedia = { "Monty Python em Busca do Cálice Sagrado", "Robin Hood: Homens de Tanga", "Shrek", "Coração de Cavaleiro" };
        String[] medievalDrama = { "Gladiador", "O Nome da Rosa", "O Reino dos Céus", "Coração Valente" };

        Scanner leitor = new Scanner(System.in);

        // Pergunta 1: Ambientação
        System.out.println("Que ambientação você prefere?");
        System.out.println("1 - Sci-fi");
        System.out.println("2 - Medieval");
        int primeiraEscolha = Integer.parseInt(leitor.nextLine());

        // Verifica se a resposta é válida
        if (primeiraEscolha != 1 && primeiraEscolha != 2) {
            System.out.println("Opção inválida. Encerrando o programa.");
            return;
        }

        // Pergunta 2: Gênero
        System.out.println("Que gênero você prefere?");
        System.out.println("1 - Comédia");
        System.out.println("2 - Drama");
        int segundaEscolha = Integer.parseInt(leitor.nextLine());

        // Verifica se a resposta é válida
        if (segundaEscolha != 1 && segundaEscolha != 2) {
            System.out.println("Opção inválida. Encerrando o programa.");
            return;
        }

        String[] recomendacoes = {};

        // Define as recomendações com base nas respostas
        if (primeiraEscolha == 1 && segundaEscolha == 1) {
            recomendacoes = scifiComedia;
        } else if (primeiraEscolha == 1 && segundaEscolha == 2) {
            recomendacoes = scifiDrama;
        } else if (primeiraEscolha == 2 && segundaEscolha == 1) {
            recomendacoes = medievalComedia;
        } else if (primeiraEscolha == 2 && segundaEscolha == 2) {
            recomendacoes = medievalDrama;
        }

        // Seleciona uma recomendação aleatória e a exibe
        if (recomendacoes.length > 0) {
            int index = new Random().nextInt(recomendacoes.length);
            System.out.println("Recomendação: " + recomendacoes[index]);
        } else {
            System.out.println("Nenhuma recomendação disponível.");
        }
    }
}