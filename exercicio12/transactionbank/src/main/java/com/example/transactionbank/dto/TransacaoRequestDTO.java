package com.example.transactionbank.dto;

public record TransacaoRequestDTO(String origem, String destino, Double valor) {}