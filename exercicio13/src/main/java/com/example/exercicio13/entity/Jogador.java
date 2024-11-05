package com.example.exercicio13.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String apelido;

    @Column(nullable = false)
    private Integer habilidade;
}