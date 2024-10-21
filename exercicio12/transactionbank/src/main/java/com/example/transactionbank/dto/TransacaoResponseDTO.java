package com.example.transactionbank.dto;

public record TransacaoResponseDTO(ContaDTO origem, ContaDTO destino, double valor) {}