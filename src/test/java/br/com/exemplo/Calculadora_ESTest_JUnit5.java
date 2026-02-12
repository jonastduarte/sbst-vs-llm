package br.com.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes convertidos do EvoSuite (JUnit 4 + EvoSuite Runtime)
 * para JUnit 5 puro, mantendo os mesmos valores e asserções.
 *
 * Original gerado automaticamente pelo EvoSuite em:
 * Thu Feb 12 02:02:32 GMT 2026
 *
 * 6 testes, critério: Branch Coverage
 */
class Calculadora_ESTest_JUnit5 {

    @Test
    void test0() {
        Calculadora calculadora0 = new Calculadora();
        boolean boolean0 = calculadora0.ehPar(-2694);
        assertTrue(boolean0);
    }

    @Test
    void test1() {
        Calculadora calculadora0 = new Calculadora();
        boolean boolean0 = calculadora0.ehPar(-4311);
        assertFalse(boolean0);
    }

    @Test
    void test2() {
        Calculadora calculadora0 = new Calculadora();
        double double0 = calculadora0.calcularDesconto(2);
        assertEquals(0.0, double0, 0.01);
    }

    @Test
    void test3() {
        Calculadora calculadora0 = new Calculadora();
        double double0 = calculadora0.calcularDesconto(616.6794156462);
        assertEquals(30.833970782310004, double0, 0.01);
    }

    @Test
    void test4() {
        Calculadora calculadora0 = new Calculadora();
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora0.calcularDesconto(-1.0);
        });
    }

    @Test
    void test5() {
        Calculadora calculadora0 = new Calculadora();
        double double0 = calculadora0.calcularDesconto(1897.0426148696329);
        assertEquals(189.7042614869633, double0, 0.01);
    }
}
