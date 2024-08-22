package org.example;

public class Main {
    public static void main(String[] args) {
        // Criação dos personagens
        Personagem orc = new Personagem("Orc", 100, 10);
        Personagem goblin = new Personagem("Goblin", 50, 5);
        Personagem lobo = new Personagem("Lobo", 75, 15);
        Personagem cavaleiro = new Personagem("Cavaleiro", 200, 20);
        Personagem dragao = new Personagem("Dragão", 500, 50);

        // Criação do jogador
        Personagem jogador = new Personagem("Steve", 100, 20);

        // Criação do jogo e adição dos inimigos
        Jogo jogo = new Jogo(jogador);
        jogo.adicionarInimigo(orc);
        jogo.adicionarInimigo(goblin);
        jogo.adicionarInimigo(lobo);
        jogo.adicionarInimigo(cavaleiro);
        jogo.adicionarInimigo(dragao);

        // Iniciar a batalha
        jogo.iniciarBatalha();
    }
}