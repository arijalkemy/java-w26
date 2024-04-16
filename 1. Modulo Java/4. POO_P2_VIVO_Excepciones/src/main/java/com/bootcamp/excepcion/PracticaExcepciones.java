package com.bootcamp.excepcion;
public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void dividir() {
        try {
            if (a == 0) {
                throw new IllegalArgumentException();
            }
            int c = b / a;
            System.out.println(c);
        } catch (IllegalArgumentException e) {
            System.out.println("El valor de a no puede ser cero");
        }
    }
}
