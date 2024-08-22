package org.example;

/**
 * A classe LargePort representa um porto grande que só permite atracagem
 * de barcos com tamanho maior ou igual a 10.
 */
public class LargePort extends Dock {

    /**
     * Construtor para inicializar um porto grande com um nome específico.
     *
     * @param name O nome do porto grande.
     */
    public LargePort(String name) {
        super(name);
    }

    /**
     * Sobrescrita do método dockVessel para garantir que apenas barcos
     * com tamanho maior ou igual a 10 possam atracar.
     *
     * @param vessel O barco a ser atracado.
     */
    @Override
    public void dockVessel(Vessel vessel) {
        if (vessel.getSize() >= 10) {
            super.dockVessel(vessel);
        } else {
            System.out.println(vessel.getName() + " não pode atracar no " + name + " devido ao tamanho.");
        }
    }
}