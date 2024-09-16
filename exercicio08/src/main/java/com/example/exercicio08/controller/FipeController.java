package com.example.exercicio08.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fipe")
public class FipeController {

    private final WebClient webClient;

    public FipeController() {
        this.webClient = WebClient.create("https://parallelum.com.br");
    }

    @GetMapping("/marca/{nomeMarca}")
    public Mono<String> getCodigoMarca(@PathVariable String nomeMarca) {
        return webClient.get()
                .uri("/fipe/api/v1/carros/marcas")
                .retrieve()
                .bodyToFlux(Map.class)
                .filter(marca -> marca.get("nome").toString().equalsIgnoreCase(nomeMarca))
                .map(marca -> marca.get("codigo").toString())
                .next();
    }

    @GetMapping("/modelo/{codigoMarca}/{nomeModelo}")
    public Mono<String> getCodigoModelo(@PathVariable String codigoMarca, @PathVariable String nomeModelo) {
        return webClient.get()
                .uri("/fipe/api/v1/carros/marcas/{codigoMarca}/modelos", codigoMarca)
                .retrieve()
                .bodyToMono(Map.class)
                .flatMapMany(response -> {
                    List<Map<String, Object>> modelos = (List<Map<String, Object>>) response.get("modelos");
                    return modelos.stream().filter(modelo -> modelo.get("nome").toString().equalsIgnoreCase(nomeModelo)).findFirst().map(modelo -> Mono.just(modelo.get("codigo").toString())).orElse(Mono.empty());
                }).next();
    }

    @GetMapping("/ano/{codigoMarca}/{codigoModelo}/{ano}")
    public Mono<String> getCodigoAno(@PathVariable String codigoMarca, @PathVariable String codigoModelo, @PathVariable int ano) {
        return webClient.get()
                .uri("/fipe/api/v1/carros/marcas/{codigoMarca}/modelos/{codigoModelo}/anos", codigoMarca, codigoModelo)
                .retrieve()
                .bodyToFlux(Map.class)
                .filter(anoMap -> anoMap.get("nome").toString().equalsIgnoreCase(String.valueOf(ano)))
                .map(anoMap -> anoMap.get("codigo").toString())
                .next();
    }

    @PostMapping
    public Mono<Map<String, String>> getValor(@RequestBody CarroRequest carroRequest) {
        return getCodigoMarca(carroRequest.getMarca())
                .flatMap(codigoMarca -> getCodigoModelo(codigoMarca, carroRequest.getModelo())
                        .flatMap(codigoModelo -> getCodigoAno(codigoMarca, codigoModelo, carroRequest.getAno())
                                .flatMap(codigoAno -> webClient.get()
                                        .uri("/fipe/api/v1/carros/marcas/{codigoMarca}/modelos/{codigoModelo}/anos/{codigoAno}", codigoMarca, codigoModelo, codigoAno)
                                        .retrieve()
                                        .bodyToMono(Map.class)
                                        .map(resposta -> {
                                            Map<String, String> resultado = new HashMap<>();
                                            resultado.put("valor", resposta.get("Valor").toString());
                                            resultado.put("mes", resposta.get("MesReferencia").toString());
                                            return resultado;
                                        })
                                )
                        )
                );
    }
}
