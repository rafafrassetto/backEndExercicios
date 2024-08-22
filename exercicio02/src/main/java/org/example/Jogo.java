package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo {
    private List<Personagem> inimigos;
    private Personagem jogador;

    public Jogo(Personagem jogador) {
        this.jogador = jogador;
        this.inimigos = new ArrayList<>();
    }

    public void adicionarInimigo(Personagem inimigo) {
        inimigos.add(inimigo);
    }

    public void iniciarBatalha() {
        Random random = new Random();

        while (jogador.getVida() > 0 && inimigos.stream().anyMatch(inimigo -> inimigo.getVida() > 0)) {
            // Jogador ataca um inimigo aleatório que ainda tem vida
            Personagem inimigoAleatorio;
            do {
                inimigoAleatorio = inimigos.get(random.nextInt(inimigos.size()));
            } while (inimigoAleatorio.getVida() <= 0);

            jogador.atacar(inimigoAleatorio);

            // Inimigos atacam o jogador
            for (Personagem inimigo : inimigos) {
                if (inimigo.getVida() > 0) {
                    inimigo.atacar(jogador);
                    if (jogador.getVida() <= 0) {
                        break;
                    }
                }
            }
        }

        // Resultado final
        if (jogador.getVida() > 0) {
            System.out.println(jogador.getNome() + " venceu a batalha!");
        } else {
            System.out.println(jogador.getNome() + " foi derrotado!");
        }
    }
}