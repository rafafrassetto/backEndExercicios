package org.example;

/**
 * A classe Vessel representa um barco com um nome e um tamanho.
 */
public class Vessel {
    private String name;
    private int size;

    /**
     * Construtor para inicializar um barco com um nome e um tamanho específicos.
     *
     * @param name O nome do barco.
     * @param size O tamanho do barco.
     */
    public Vessel(String name, int size) {
        this.name = name;
        this.size = size;
    }

    /**
     * Retorna o nome do barco.
     *
     * @return O nome do barco.
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna o tamanho do barco.
     *
     * @return O tamanho do barco.
     */
    public int getSize() {
        return size;
    }
}