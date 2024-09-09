package com.example.exercicio07;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
class FilmeControllerTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void testRecomendarFilme() throws Exception {
        mockMvc.perform(get("/recomendar")
                .param("genero", "acao")
                .param("ambiente", "futurista"))
                .andExpect(status().isOk())
                .andExpect(content().string("Homens de Preto"));
    }

    @Test
    void testRecomendarFilmeNotFound() throws Exception {
        mockMvc.perform(get("/recomendar")
                .param("genero", "acao")
                .param("ambiente", "historico"))
                .andExpect(status().isOk())
                .andExpect(content().string("Filme não encontrado para os parâmetros fornecidos."));
    }
}