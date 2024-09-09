package com.example.musiccloud;

import java.util.ArrayList;
import java.util.List;

public class MusicCloud {
    private List<Musica> musicasDisponiveis;

    public MusicCloud() {
        musicasDisponiveis = new ArrayList<>();
        carregarMusicas();
    }

    private void carregarMusicas() {
        // Adicionando músicas disponíveis
        musicasDisponiveis.add(new Musica("Hino do Real Paulista", "Artista 1"));
        musicasDisponiveis.add(new Musica("Macarena", "Artista 2"));
        musicasDisponiveis.add(new Musica("Evidências", "Artista 3"));
        // Adicione mais músicas se desejar
    }

    public Musica buscarMusica(String titulo) {
        for (Musica musica : musicasDisponiveis) {
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                return musica;
            }
        }
        return null;
    }
}