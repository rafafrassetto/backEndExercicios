package com.example.transactionbank;

public class Transacao {
    private Conta origem;
    private Conta destino;
    private double valor;

    public Transacao(Conta origem, Conta destino, double valor) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    }

    public Conta getOrigem() {
        return origem;
    }

    public Conta getDestino() {
        return destino;
    }

    public double getValor() {
        return valor;
    }
}