package org.example.circuit_breaker_spring.controllers;

import org.example.circuit_breaker_spring.classes.GeradorAnimal;
import org.example.circuit_breaker_spring.variaveis.VariaveisDaAplicacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animais")
public class GeradorAnimalController {

    @GetMapping
    public ResponseEntity<String> geraCombinacaoAnimal() {

        if (VariaveisDaAplicacao.isChaveDoCaos() && VariaveisDaAplicacao.isChaveDeException()) {
            return ResponseEntity.badRequest().body("Erro ao processar a requisição!");
        }

        String response = GeradorAnimal.geraCombinacao();

        return ResponseEntity.ok().body(response);
    }
}