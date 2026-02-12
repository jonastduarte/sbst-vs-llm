# Relatório Comparativo: SBST (EvoSuite) vs LLM (IA Generativa)

**Disciplina:** Gestão de Projetos de Sistemas, IoT e IA  
**Data:** 11/02/2026

---

## 1. Objetivo
O objetivo deste trabalho foi comparar a eficácia e a cobertura de testes unitários gerados automaticamente por duas abordagens distintas:
1.  **SBST (Search-Based Software Testing):** Utilizando a ferramenta **EvoSuite**.
2.  **LLM (Large Language Model):** Utilizando IA Generativa para escrever os testes.

A comparação foca em cobertura de código (linhas e branches) e eficácia na detecção de falhas (mutation score).

## 2. Metodologia

### Ferramentas Utilizadas
-   **Linguagem:** Java 17 (código fonte), Java 8 (execução EvoSuite).
-   **Frameworks de Teste:** JUnit 5.
-   **Cobertura:** JaCoCo 0.8.12.
-   **Teste de Mutação:** PIT (Pitest) 1.15.0.
-   **Gerador SBST:** EvoSuite 1.2.0 (critério: Branch Coverage).
-   **Gerador LLM:** Simulação de IA Generativa com prompt para "testes exaustivos e casos de borda".

### Objeto de Teste
A classe `Calculadora.java` contendo:
-   Método `calcularDesconto(double valor)`: Lógica condicional com faixas de desconto (0%, 5%, 10%) e exceção para valores inválidos.
-   Método `ehPar(int numero)`: Verificação simples de paridade.

### Métricas Coletadas
-   **Line Coverage:** Porcentagem de linhas de código executadas.
-   **Branch Coverage:** Porcentagem de ramificações (if/else) executadas.
-   **Mutation Score:** Porcentagem de mutantes "mortos" (falhas artificiais detectadas pelos testes).
-   **Esforço Manual:** Avaliação qualitativa da necessidade de ajustes no código gerado.

---

## 3. Resultados

A tabela abaixo resume os resultados obtidos após a execução das dias suítes de teste:

| Métrica | EvoSuite (SBST) | LLM (IA Generativa) |
| :--- | :--- | :--- |
| **Line Coverage** | 100% (9/9) | 100% (9/9) |
| **Branch Coverage** | 100% (8/8) | 100% (8/8) |
| **Mutation Score** | **77% (10/13)** | **100% (13/13)** |
| **Nº de Testes** | 6 | 26 |
| **Legibilidade** | Baixa (código complexo, nomes genéricos) | Alta (nomes descritivos, código limpo) |
| **Esforço Correção** | Alto (requer adaptação de runtime/JUnit 4) | Baixo (código pronto para uso) |

### Análise dos Mutantes (PIT)
-   **LLM (100%):** A suíte gerada pela LLM conseguiu matar todos os 13 mutantes gerados pelo PIT. Isso indica que as asserções eram robustas e verificavam precisamente os valores de retorno e efeitos colaterais.
-   **EvoSuite (77%):** Apesar de atingir 100% de cobertura de linha e branch, a suíte do EvoSuite deixou passar 3 mutantes (sobreviveram). Isso sugere que, embora o EvoSuite tenha exercitado todo o código, suas asserções (oracles) não foram estritas o suficiente para detectar pequenas alterações no comportamento (ex: limites de condicionais `<` vs `<=`).

---

## 4. Análise Crítica

### Cobertura vs Eficácia
Ambas as ferramentas atingiram **100% de cobertura estrutural** (linha e branch). No entanto, o **Mutation Score** revelou que a cobertura alta não garante testes eficazes. A LLM superou o EvoSuite significativamente neste quesito (100% vs 77%), demonstrando "test strength" superior.

### Manutenibilidade e Esforço
-   **EvoSuite:** Os testes gerados são difíceis de ler e manter. Utilizam nomes de variáveis opacos (`test0`, `calculadora0`) e dependem de um framework específico (`EvoRunner`), o que dificultou a integração com JUnit 5 e ferramentas modernas como PIT. A necessidade de Java 8 também foi um limitador técnico.
-   **LLM:** O código gerado foi limpo, documentado e seguiu as convenções modernas (JUnit 5, nomes descritivos como `calcularDesconto_valorZero_lancaExcecao`). Foi "copy-paste" para funcionar.

### Conclusão
Para a classe `Calculadora` analisada, a abordagem com **LLM foi superior**, entregando testes mais eficazes (maior mutation score) e muito mais fáceis de manter e integrar. O EvoSuite, embora poderoso para cobertura bruta, gerou testes mais frágeis e com maior custo de integração no ambiente de desenvolvimento atual.
