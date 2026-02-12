package br.com.exemplo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes JUnit 5 exaustivos para a classe Calculadora,
 * cobrindo casos de borda, gerados por LLM.
 */
class CalculadoraTest {

    private final Calculadora calc = new Calculadora();

    // ==========================================
    // calcularDesconto — Exceções
    // ==========================================

    @Test
    @DisplayName("calcularDesconto: valor zero deve lançar exceção")
    void calcularDesconto_valorZero_lancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> calc.calcularDesconto(0));
    }

    @Test
    @DisplayName("calcularDesconto: valor negativo deve lançar exceção")
    void calcularDesconto_valorNegativo_lancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> calc.calcularDesconto(-1));
    }

    @Test
    @DisplayName("calcularDesconto: valor muito negativo deve lançar exceção")
    void calcularDesconto_valorMuitoNegativo_lancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> calc.calcularDesconto(-1000));
    }

    // ==========================================
    // calcularDesconto — Sem desconto (0 < valor <= 500)
    // ==========================================

    @Test
    @DisplayName("calcularDesconto: valor 1 (mínimo válido) retorna 0")
    void calcularDesconto_valor1_retorna0() {
        assertEquals(0, calc.calcularDesconto(1));
    }

    @Test
    @DisplayName("calcularDesconto: valor 250 retorna 0")
    void calcularDesconto_valor250_retorna0() {
        assertEquals(0, calc.calcularDesconto(250));
    }

    @Test
    @DisplayName("calcularDesconto: valor 499.99 retorna 0")
    void calcularDesconto_valor499_retorna0() {
        assertEquals(0, calc.calcularDesconto(499.99));
    }

    @Test
    @DisplayName("calcularDesconto: valor exato 500 (limite) retorna 0")
    void calcularDesconto_valor500_retorna0() {
        assertEquals(0, calc.calcularDesconto(500));
    }

    // ==========================================
    // calcularDesconto — 5% (500 < valor <= 1000)
    // ==========================================

    @Test
    @DisplayName("calcularDesconto: valor 500.01 retorna 5%")
    void calcularDesconto_valor500_01_retorna5porcento() {
        assertEquals(500.01 * 0.05, calc.calcularDesconto(500.01), 0.01);
    }

    @Test
    @DisplayName("calcularDesconto: valor 501 retorna 5%")
    void calcularDesconto_valor501_retorna5porcento() {
        assertEquals(501 * 0.05, calc.calcularDesconto(501), 0.01);
    }

    @Test
    @DisplayName("calcularDesconto: valor 750 retorna 5%")
    void calcularDesconto_valor750_retorna5porcento() {
        assertEquals(750 * 0.05, calc.calcularDesconto(750), 0.01);
    }

    @Test
    @DisplayName("calcularDesconto: valor 999.99 retorna 5%")
    void calcularDesconto_valor999_retorna5porcento() {
        assertEquals(999.99 * 0.05, calc.calcularDesconto(999.99), 0.01);
    }

    @Test
    @DisplayName("calcularDesconto: valor exato 1000 (limite) retorna 5%")
    void calcularDesconto_valor1000_retorna5porcento() {
        assertEquals(1000 * 0.05, calc.calcularDesconto(1000), 0.01);
    }

    // ==========================================
    // calcularDesconto — 10% (valor > 1000)
    // ==========================================

    @Test
    @DisplayName("calcularDesconto: valor 1000.01 retorna 10%")
    void calcularDesconto_valor1000_01_retorna10porcento() {
        assertEquals(1000.01 * 0.10, calc.calcularDesconto(1000.01), 0.01);
    }

    @Test
    @DisplayName("calcularDesconto: valor 1001 retorna 10%")
    void calcularDesconto_valor1001_retorna10porcento() {
        assertEquals(1001 * 0.10, calc.calcularDesconto(1001), 0.01);
    }

    @Test
    @DisplayName("calcularDesconto: valor 5000 retorna 10%")
    void calcularDesconto_valor5000_retorna10porcento() {
        assertEquals(5000 * 0.10, calc.calcularDesconto(5000), 0.01);
    }

    @Test
    @DisplayName("calcularDesconto: valor muito alto retorna 10%")
    void calcularDesconto_valorMuitoAlto_retorna10porcento() {
        assertEquals(1000000 * 0.10, calc.calcularDesconto(1000000), 0.01);
    }

    // ==========================================
    // ehPar — Casos positivos
    // ==========================================

    @Test
    @DisplayName("ehPar: 0 é par")
    void ehPar_zero_retornaTrue() {
        assertTrue(calc.ehPar(0));
    }

    @Test
    @DisplayName("ehPar: 2 é par")
    void ehPar_dois_retornaTrue() {
        assertTrue(calc.ehPar(2));
    }

    @Test
    @DisplayName("ehPar: 100 é par")
    void ehPar_cem_retornaTrue() {
        assertTrue(calc.ehPar(100));
    }

    @Test
    @DisplayName("ehPar: -4 é par")
    void ehPar_negativoPar_retornaTrue() {
        assertTrue(calc.ehPar(-4));
    }

    // ==========================================
    // ehPar — Casos negativos (ímpares)
    // ==========================================

    @Test
    @DisplayName("ehPar: 1 é ímpar")
    void ehPar_um_retornaFalse() {
        assertFalse(calc.ehPar(1));
    }

    @Test
    @DisplayName("ehPar: 3 é ímpar")
    void ehPar_tres_retornaFalse() {
        assertFalse(calc.ehPar(3));
    }

    @Test
    @DisplayName("ehPar: 99 é ímpar")
    void ehPar_noventaNove_retornaFalse() {
        assertFalse(calc.ehPar(99));
    }

    @Test
    @DisplayName("ehPar: -7 é ímpar")
    void ehPar_negativoImpar_retornaFalse() {
        assertFalse(calc.ehPar(-7));
    }

    // ==========================================
    // ehPar — Limites (Integer.MAX_VALUE, MIN_VALUE)
    // ==========================================

    @Test
    @DisplayName("ehPar: Integer.MAX_VALUE é ímpar")
    void ehPar_maxValue_retornaFalse() {
        assertFalse(calc.ehPar(Integer.MAX_VALUE));
    }

    @Test
    @DisplayName("ehPar: Integer.MIN_VALUE é par")
    void ehPar_minValue_retornaTrue() {
        assertTrue(calc.ehPar(Integer.MIN_VALUE));
    }
}
