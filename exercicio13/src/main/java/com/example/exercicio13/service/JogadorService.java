package com.example.exercicio13.service;

import com.example.exercicio13.dto.JogadorDTO;
import com.example.exercicio13.entity.Jogador;
import com.example.exercicio13.mapper.JogadorMapper;
import com.example.exercicio13.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private JogadorMapper jogadorMapper;

    public JogadorDTO criarJogador(JogadorDTO jogadorDTO) {
        Jogador jogador = jogadorMapper.toEntity(jogadorDTO);
        jogador = jogadorRepository.save(jogador);
        return jogadorMapper.toDTO(jogador);
    }

    public List<JogadorDTO> listarJogadores() {
        return jogadorRepository.findAll()
                .stream()
                .map(jogadorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deletarJogador(Long id) {
        jogadorRepository.deleteById(id);
    }
}