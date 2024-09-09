package com.example.musiccloud;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;
    private List<Musica> musicas;

    public Playlist(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Playlist: ").append(nome).append("\n");
        for (Musica musica : musicas) {
            sb.append("- ").append(musica.getTitulo()).append("\n");
        }
        return sb.toString();
    }
}