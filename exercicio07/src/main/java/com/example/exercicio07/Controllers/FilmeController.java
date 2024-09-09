package com.example.exercicio07.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmeController {

    @GetMapping("/recomendar")
    public String recomendarFilme(@RequestParam String genero, @RequestParam String ambiente) {
        if ("acao".equalsIgnoreCase(genero) && "futurista".equalsIgnoreCase(ambiente)) {
            return "Homens de Preto";
        }
        return "Filme não encontrado para os parâmetros fornecidos.";
    }
}
