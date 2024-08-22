package org.example;

public class Personagem {
    private String nome;
    private int vida;
    private int ataque;

    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida <= 0) {
            vida = 0;
            System.out.println(nome + " foi derrotado!");
        }
    }

    public void atacar(Personagem alvo) {
        if (vida > 0 && alvo.getVida() > 0) {
            alvo.receberDano(ataque);
            if (alvo.getVida() == 0) {
                System.out.println("O ataque falhou, " + alvo.getNome() + " já está derrotado!");
            }
        } else if (vida <= 0) {
            System.out.println(nome + " não pode atacar pois foi derrotado!");
        }
    }
}