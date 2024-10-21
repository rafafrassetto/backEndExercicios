package com.example.transactionbank.mapper;

import com.example.transactionbank.Conta;
import com.example.transactionbank.dto.ContaDTO;

public class ContaMapper {
    public static ContaDTO toDTO(Conta conta) {
        return new ContaDTO(conta.getCodigo(), conta.getCliente());
    }
}