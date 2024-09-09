package com.example.musiccloud;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicCloud musicCloud = new MusicCloud();
        Playlist playlist = null;

        while (true) {
            System.out.println("Digite o nome da playlist (ou 'sair' para encerrar): ");
            String nomePlaylist = scanner.nextLine();
            if ("sair".equalsIgnoreCase(nomePlaylist)) {
                break;
            }

            playlist = new Playlist(nomePlaylist);

            while (true) {
                System.out.println("Digite o nome da música (ou 'concluir' para finalizar a playlist): ");
                String tituloMusica = scanner.nextLine();
                if ("concluir".equalsIgnoreCase(tituloMusica)) {
                    break;
                }

                Musica musica = musicCloud.buscarMusica(tituloMusica);
                if (musica != null) {
                    playlist.adicionarMusica(musica);
                    System.out.println("Você adicionou a música " + musica.getTitulo() + " na playlist.");
                } else {
                    System.out.println("A música " + tituloMusica + " não foi encontrada no sistema.");
                }
            }

            if (playlist != null) {
                System.out.println(playlist);
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}