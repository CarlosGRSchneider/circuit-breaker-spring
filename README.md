# Circuit Breaker Spring

Este projeto implementa uma API simples utilizando Spring Boot para expor endpoints que serão consumidos por um segundo microsserviço com circuit breaker. Apesar de não conter circuitos, este projeto é essencial para o funcionamento do [circuit-breaker-caller-spring](https://github.com/CarlosGRSchneider/circuit-breaker-caller-spring).

## Descrição

A API expõe dois endpoints principais, além de dois endpoints auxiliares para simulação de falhas:

### Endpoints principais:
1. **Gerar combinação de animal**:
   - Gera uma combinação aleatória de um adjetivo e um animal, como "Elefante Alegre" ou "Tigre Astuto".
   - Rota: `GET /animais`

2. **Cálculo complexo**:
   - Realiza a soma de dois inteiros fornecidos no corpo da requisição.
   - Rota: `POST /calculadora`
   - Corpo esperado:
     ```json
     {
       "numeroUm": 10,
       "numeroDois": 20
     }
     ```

### Endpoints auxiliares:
1. **Inserir erro proposital**:
   - Ativa ou desativa a "chave do caos" para simular falhas.
   - Rota: `GET /dev-tools/caos`

2. **Configurar latência**:
   - Define um tempo de latência (em milissegundos) para as respostas da API.
   - Rota: `POST /dev-tools/latencia`
   - Corpo esperado: Número inteiro representando a latência em milissegundos (ex.: `"500"`).

## Requisitos

- Java 17+
- Maven 3.8+

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/CarlosGRSchneider/circuit-breaker-spring.git
   cd circuit-breaker-spring
   ```

2. Compile e execute o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```

3. A API estará disponível em `http://localhost:9090`.

## Exemplo de Uso

1. **Gerar combinação de animal:**
   ```bash
   curl -X GET http://localhost:9090/animais
   ```

   Resposta:
   ```json
   "Canguru Inteligente"
   ```

2. **Realizar cálculo complexo:**
   ```bash
   curl -X POST http://localhost:9090/calculadora \
     -H "Content-Type: application/json" \
     -d '{"numeroUm": 15, "numeroDois": 25}'
   ```

   Resposta:
   ```json
   "Soma complexa: 40"
   ```

3. **Simular latência:**
   ```bash
   curl -X POST http://localhost:9090/dev-tools/latencia \
     -H "Content-Type: text/plain" \
     -d "500"
   ```

   Resposta:
   ```json
   "Latência definida com sucesso para 500ms"
   ```

4. **Ativar "chave do caos":**
   ```bash
   curl -X GET http://localhost:9090/dev-tools/caos
   ```

   Resposta:
   ```json
   true
   ```

## Estrutura do Projeto

- **GeradorAnimal**: Classe utilitária para gerar combinações de adjetivos e animais.
- **Controllers**:
  - `CalculadoraController`: Responsável por realizar o "cálculo complexo".
  - `DevToolsController`: Fornece ferramentas para inserir falhas e latência.
  - `GeradorAnimalController`: Exposição do endpoint de geração de combinações de animais.
- **VariaveisDaAplicacao**: Classe que gerencia o estado da aplicação (como a chave do caos e a latência).
- **Requests**:
  - `CalculadoraRequest`: Modelo utilizado para o endpoint de cálculo.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para a construção da API.
- **Java 17**: Linguagem de programação.

---

> **Nota:** Este projeto foi desenvolvido como parte de um estudo sobre circuit breakers e deve ser utilizado em conjunto com o projeto [circuit-breaker-caller-spring](https://github.com/CarlosGRSchneider/circuit-breaker-caller-spring).
