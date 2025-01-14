package org.example.circuit_breaker_spring.controllers;

import org.example.circuit_breaker_spring.variaveis.VariaveisDaAplicacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev-tools")
public class DevToolsController {

    @GetMapping(value = "/caos")
    public ResponseEntity<Boolean> alteraChaveDoCaos() {

        boolean result = VariaveisDaAplicacao.alteraEstadoDaChaveDoCaos();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = "/latencia")
    public ResponseEntity<String> defineLatencia(@RequestBody String latencia) {

        try {
            VariaveisDaAplicacao.setLatencia(Integer.parseInt(latencia));

            return ResponseEntity.ok().body("Latência definida com sucesso para " + latencia + "ms");
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Valor de latência inválido. Somente são aceitos números inteiros positivos");
        }
    }
}
