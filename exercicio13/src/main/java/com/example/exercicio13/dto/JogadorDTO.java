package com.example.exercicio13.dto;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class JogadorDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Apelido é obrigatório")
    private String apelido;

    @NotNull(message = "Habilidade é obrigatória")
    @Min(value = 1, message = "Habilidade mínima é 1")
    @Max(value = 100, message = "Habilidade máxima é 100")
    private Integer habilidade;
}