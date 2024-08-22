package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe Dock representa um porto genérico onde barcos podem atracar.
 */
public class Dock {
    protected String name;
    protected List<Vessel> dockedVessels;

    /**
     * Construtor para inicializar um porto com um nome específico.
     *
     * @param name O nome do porto.
     */
    public Dock(String name) {
        this.name = name;
        this.dockedVessels = new ArrayList<>();
    }

    /**
     * Método para atracar um barco no porto.
     *
     * @param vessel O barco a ser atracado.
     */
    public void dockVessel(Vessel vessel) {
        dockedVessels.add(vessel);
        System.out.println(vessel.getName() + " atracado no " + name);
    }

    /**
     * Método para desatracar um barco do porto.
     *
     * @param vessel O barco a ser desatracado.
     */
    public void undockVessel(Vessel vessel) {
        dockedVessels.remove(vessel);
        System.out.println(vessel.getName() + " desatracado do " + name);
    }
}