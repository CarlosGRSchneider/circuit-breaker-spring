package org.example.circuit_breaker_spring.classes;

import java.util.List;
import java.util.Random;

public class GeradorAnimal {

    private static Random random = new Random();
    private static final List<String> ADJETIVOS = List.of(
            """
                    alegre curioso tranquilo rápido brincalhão atento inteligente gentil elegante perplexo sonolento fiel astuto amigável paciente educado corajoso campeiro ambicioso ninja
                    """.strip().replace("\n", " ").split("\\s+")
    );
    private static final List<String> animais = List.of(
            """
                    Caranguejo Quati Suricato Elefante Leão Tigre Urso Lobo Panda Canguru Golfinho Ratão-do-banhado Pica-pau Gavião Coala Quero-quero Sapo Cachorro Gato Grilo
                    """.strip().replace("\n", " ").split("\\s+")
    );

    public static String geraCombinacao() {

        String animal = animais.get(random.nextInt(animais.size()));
        String adjetivo = ADJETIVOS.get(random.nextInt(ADJETIVOS.size()));
        return animal + " " + adjetivo;
    }
}
