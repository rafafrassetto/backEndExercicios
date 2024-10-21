package com.example.transactionbank.controller;

import com.example.transactionbank.dto.TransacaoRequestDTO;
import com.example.transactionbank.dto.TransacaoResponseDTO;
import com.example.transactionbank.service.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    @Autowired
    private TransacoesService transacoesService;

    @PostMapping
    public TransacaoResponseDTO gerarTransacao(@RequestBody TransacaoRequestDTO request) {
        return transacoesService.realizarTransacao(request);
    }
}