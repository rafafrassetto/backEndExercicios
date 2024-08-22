package org.example;

/**
 * A classe SmallPort representa um porto pequeno que só permite atracagem
 * de barcos com tamanho menor ou igual a 10.
 */
public class SmallPort extends Dock {

    /**
     * Construtor para inicializar um porto pequeno com um nome específico.
     *
     * @param name O nome do porto pequeno.
     */
    public SmallPort(String name) {
        super(name);
    }

    /**
     * Sobrescrita do método dockVessel para garantir que apenas barcos
     * com tamanho menor ou igual a 10 possam atracar.
     *
     * @param vessel O barco a ser atracado.
     */
    @Override
    public void dockVessel(Vessel vessel) {
        if (vessel.getSize() <= 10) {
            super.dockVessel(vessel);
        } else {
            System.out.println(vessel.getName() + " não pode atracar no " + name + " devido ao tamanho.");
        }
    }
}