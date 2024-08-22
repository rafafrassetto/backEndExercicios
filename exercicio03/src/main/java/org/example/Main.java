package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe Main é o ponto de entrada do programa que gerencia a atracagem de barcos em portos.
 */
public class Main {
    public static void main(String[] args) {
        // Criação dos barcos com diferentes tamanhos
        Vessel vessel1 = new Vessel("Barco 1", 2);
        Vessel vessel2 = new Vessel("Barco 2", 5);
        Vessel vessel3 = new Vessel("Barco 3", 7);
        Vessel vessel4 = new Vessel("Barco 4", 12);
        Vessel vessel5 = new Vessel("Barco 5", 20);

        // Adicionando os barcos a uma lista
        List<Vessel> vessels = new ArrayList<>();
        vessels.add(vessel1);
        vessels.add(vessel2);
        vessels.add(vessel3);
        vessels.add(vessel4);
        vessels.add(vessel5);

        // Criação dos portos, um pequeno e um grande
        SmallPort smallPort = new SmallPort("Porto Pequeno");
        LargePort largePort = new LargePort("Porto Grande");

        // Tentativa de atracação: primeiro no porto pequeno, depois no porto grande, se necessário
        for (Vessel vessel : vessels) {
            if (vessel.getSize() <= 10) {
                smallPort.dockVessel(vessel);
            } else {
                largePort.dockVessel(vessel);
            }
        }
    }
}