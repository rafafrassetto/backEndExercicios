package com.example.transactionbank.service;

import com.example.transactionbank.Conta;
import com.example.transactionbank.Transacao;
import com.example.transactionbank.dto.TransacaoRequestDTO;
import com.example.transactionbank.dto.TransacaoResponseDTO;
import com.example.transactionbank.mapper.ContaMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransacoesService {
    private List<Conta> contas;

    public TransacoesService() {
        contas = new ArrayList<>();
        contas.add(new Conta("500-1", "Fulano", 1000));
        contas.add(new Conta("320-2", "Ciclano", 500));
    }

    public TransacaoResponseDTO realizarTransacao(TransacaoRequestDTO request) {
        Conta origem = buscarConta(request.origem());
        Conta destino = buscarConta(request.destino());

        if (origem == null || destino == null) {
            throw new IllegalArgumentException("Conta origem ou destino não encontrada");
        }

        origem.debitar(request.valor());
        destino.creditar(request.valor());

        Transacao transacao = new Transacao(origem, destino, request.valor());

        return new TransacaoResponseDTO(ContaMapper.toDTO(origem), ContaMapper.toDTO(destino), transacao.getValor());
    }

    private Conta buscarConta(String codigo) {
        Optional<Conta> conta = contas.stream().filter(c -> c.getCodigo().equals(codigo)).findFirst();
        return conta.orElse(null);
    }
}