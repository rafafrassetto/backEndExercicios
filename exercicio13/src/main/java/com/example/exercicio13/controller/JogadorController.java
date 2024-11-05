package com.example.exercicio13.controller;

import com.example.exercicio13.dto.JogadorDTO;
import com.example.exercicio13.service.JogadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JogadorDTO criarJogador(@Valid @RequestBody JogadorDTO jogadorDTO) {
        return jogadorService.criarJogador(jogadorDTO);
    }

    @GetMapping
    public List<JogadorDTO> listarJogadores() {
        return jogadorService.listarJogadores();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarJogador(@PathVariable Long id) {
        jogadorService.deletarJogador(id);
    }
}