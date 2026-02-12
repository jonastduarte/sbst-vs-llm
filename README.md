# Comparando SBST vs LLM

Este projeto compara a geração automática de testes utilizando dois métodos distintos:

1.  **SBST (Search-Based Software Testing):** Utilizando **EvoSuite** (testes evolucionários).
2.  **LLM (Large Language Model):** Utilizando **IA Generativa** (testes assistidos).

A classe alvo é `br.com.exemplo.Calculadora`, contendo lógica condicional e exceções.

## Estrutura do Projeto

-   `/evosuite`: Contém os testes gerados automaticamente pelo EvoSuite (adaptados para JUnit 5).
-   `/llm`: Contém os testes gerados pela IA Generativa (JUnit 5 puro).
-   `src/main/java`: Código fonte da aplicação (`Calculadora.java`).
-   `src/test/java`: Contém os testes para execução via Maven (atualmente com a suíte LLM ativa).
-   `RELATORIO.md`: Relatório comparativo detalhando metodologia, resultados e análise crítica.

## Resultados Obtidos

| Métrica | EvoSuite (SBST) | LLM (IA Generativa) |
| :--- | :--- | :--- |
| **Line Coverage** | 100% | 100% |
| **Branch Coverage** | 100% | 100% |
| **Mutation Score** | 77% | 100% |

## Como Executar

### Pré-requisitos
-   Java 11+ (Recomendado Java 17)
-   Maven 3.8+

### Executar Testes LLM (Padrão)
```bash
mvn clean test
```

### Executar PIT Mutation Testing
Para medir a eficácia dos testes (morte de mutantes):
```bash
mvn org.pitest:pitest-maven:mutationCoverage
```
O relatório será gerado em `target/pit-reports/index.html`.

### Executar Testes EvoSuite
Os testes do EvoSuite estão na pasta `/evosuite`. Para executá-los, é necessário movê-los para `src/test/java` ou configurar o Maven para incluí-los.

---
**Curso:** Pós-Graduação em Gestão de Projetos de Sistemas, IoT e IA
**Disciplina:** Inteligência Artificial
