package br.com.exemplo;

public class Calculadora {

    public double calcularDesconto(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        if (valor > 1000) {
            return valor * 0.10;
        } else if (valor > 500) {
            return valor * 0.05;
        } else {
            return 0;
        }
    }

    public boolean ehPar(int numero) {
        return numero % 2 == 0;
    }
}
