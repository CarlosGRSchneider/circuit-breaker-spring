package org.example.circuit_breaker_spring.controllers;

import org.example.circuit_breaker_spring.requests.CalculadoraRequest;
import org.example.circuit_breaker_spring.variaveis.VariaveisDaAplicacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @PostMapping
    public ResponseEntity<String> realizaCalculosComplexos(@RequestBody CalculadoraRequest request) {

        aplicaLatencia();

        int soma = request.getNumeroUm() + request.getNumeroDois();
        String response = "Soma complexa: " + soma;

        return ResponseEntity.ok().body(response);
    }

    private void aplicaLatencia() {

        try {
            Thread.sleep(VariaveisDaAplicacao.getLatencia());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
