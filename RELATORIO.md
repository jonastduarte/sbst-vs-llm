# COMPARANDO SBST VS. LLM

**Comparação da eficácia e cobertura de testes gerados por algoritmos evolutivos versus IA generativa**

## 1. Objetivo

Este trabalho tem como objetivo comparar a eficácia e a cobertura de testes unitários gerados automaticamente por duas abordagens distintas:

-   **SBST (Search-Based Software Testing)** utilizando a ferramenta **EvoSuite**.
-   **IA Generativa (LLM)** utilizando modelo de linguagem para geração de testes JUnit.

A comparação considera métricas estruturais e de eficácia real, incluindo cobertura de código e teste de mutação.

## 2. Metodologia

### 2.1 Sistema Sob Teste (SUT)

Foi utilizada uma classe Java simples denominada `Calculadora`, contendo:

-   Estruturas condicionais (if/else)
-   Tratamento de exceções
-   Método booleano simples
-   Casos de borda

A classe foi compilada utilizando Maven (Java 17).

### 2.2 Parte A — SBST (EvoSuite)

**Ferramenta utilizada:** EvoSuite 1.2.0

**Procedimentos realizados:**
1.  Compilação do projeto Maven.
2.  Geração automática de testes com critério focado em **Branch Coverage**.
3.  Execução dos testes gerados.
4.  Coleta de métricas de cobertura com JaCoCo.
5.  Execução do PIT Mutation Testing para medir a eficácia real (morte de mutantes).

Os testes gerados foram armazenados na pasta:
`/evosuite`

### 2.3 Parte B — LLM

**Ferramenta utilizada:** Modelo de Linguagem (Simulado conforme roteiro)

**Procedimentos realizados:**
1.  Solicitação de geração de testes com o prompt:
    > "Gere testes JUnit 5 exaustivos para a classe Calculadora cobrindo casos de borda."
2.  Revisão manual do código gerado.
3.  Execução dos testes.
4.  Coleta de cobertura com JaCoCo.
5.  Execução do PIT para medição de mutation score.

Os testes gerados foram armazenados na pasta:
`/llm`

### 2.4 Métricas Avaliadas

Foram analisadas as seguintes métricas:
-   **Cobertura de Linha (%)**
-   **Cobertura de Branch (%)**
-   **Mutation Score (%)**
-   **Número de testes gerados**
-   **Esforço de correção manual**

---

## 3. Resultados

### 3.1 Tabela Comparativa

| Métrica | EvoSuite (SBST) | LLM (IA Generativa) |
| :--- | :--- | :--- |
| **Line Coverage** | 100% | 100% |
| **Branch Coverage** | 100% | 100% |
| **Mutation Score** | 77% (10/13) | 100% (13/13) |
| **Nº de Testes Gerados** | 6 | 26 |
| **Esforço de Correção Manual** | Alto (Adaptação JUnit 5) | Baixo (Pronto p/ uso) |

### 3.2 Observações Experimentais

-   **EvoSuite:** Gerou automaticamente testes altamente compactos (apenas 6 métodos) que cobriram 100% das linhas e branches. No entanto, o `Mutation Score` inferior (77%) indica que suas asserções não foram suficientemente rigorosas para detectar todas as alterações de comportamento (mutantes sobreviventes).
-   **LLM:** Gerou testes mais legíveis, semânticos e numerosos (26 métodos), cobrindo exaustivamente cada caso de borda. O `Mutation Score` de 100% demonstra uma eficácia superior na detecção de falhas reais.
-   **Falhas Detectadas:**
    -   O EvoSuite deixou passar 3 mutantes (falhas artificiais sobreviventes).
    -   A LLM detectou (matou) todos os 13 mutantes gerados.

Não foram identificadas falhas funcionais no código original (SUT), pois ambos comportaram-se conforme o esperado para a implementação correta.

---

## 4. Análise Crítica

A análise dos resultados permitiu observar diferenças claras entre as abordagens.

### 4.1 SBST (EvoSuite)
-   Tendência a maximizar cobertura estrutural com o mínimo de testes.
-   Atingiu 100% de branch coverage rapidamente.
-   Testes gerados são difíceis de ler (nomes genéricos como `test0`) e de manter.
-   Baixo esforço de "geração", mas alto esforço de "integração" (requer runtime específico e Java 8).

### 4.2 LLM
-   Testes organizados, legíveis e com nomes descritivos (`calcularDesconto_valorZero_lancaExcecao`).
-   Excelente representação de casos de negócio e limites.
-   Atingiu cobertura máxima de branches e linhas neste experimento.
-   Asserções mais robustas, resultando em eficácia real (mutation score) perfeita.

### 4.3 Comparação Geral

Observou-se que:
-   O **SBST** é excelente para garantir que "todo o código seja executado", mas nem sempre garante que "todo o comportamento está correto" (oracles fracos).
-   A **LLM** gerou testes que parecem escritos por um humano cuidadoso, focando tanto na estrutura quanto na semântica do problema.
-   O **Mutation Score** se provou a métrica mais relevante, revelando a superioridade da LLM neste cenário específico (100% vs 77%).

A escolha da abordagem depende do contexto:
-   Para **cobertura de código legada/massiva** sem especificação clara → SBST.
-   Para **novas funcionalidades** onde a legibilidade e a intenção de negócio importam → LLM.

---

## 5. Conclusão

O experimento demonstrou que ambas as abordagens são eficazes na geração automática de testes, atingindo 100% de cobertura estrutural.

No entanto, neste estudo de caso, a **LLM superou o SBST em eficácia real (Mutation Score) e manutenibilidade**. O SBST mostrou ser uma ferramenta poderosa para cobertura bruta, enquanto a LLM apresentou melhor qualidade semântica e assertividade. A utilização combinada das duas técnicas pode representar a estratégia ideal: SBST para varrer caminhos difíceis e LLM para garantir a lógica de negócio.

---

## 6. Repositório

O código completo do experimento, incluindo ambas as suítes de testes, está disponível em:

**https://github.com/jonastduarte/sbst-vs-llm**

### Estrutura:
-   `/evosuite` – testes gerados por SBST
-   `/llm` – testes gerados por LLM
