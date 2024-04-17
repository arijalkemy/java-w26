package org.example;

/**
 * Hello world!
 */
public class PracticaExcepciones {

    int a, b;



    public double dividir(int a, int b) throws IllegalArgumentException {
        if (a == 0 || b == 0) throw new IllegalArgumentException("Uno de los argumentos es invalido: 0");
        return b/a;

    }
}
