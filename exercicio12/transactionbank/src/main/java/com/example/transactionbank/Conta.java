package com.example.transactionbank;

public class Conta {
    private String codigo;
    private String cliente;
    private double saldo;

    public Conta(String codigo, String cliente, double saldo) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void debitar(double valor) {
        this.saldo -= valor;
    }

    public void creditar(double valor) {
        this.saldo += valor;
    }
}