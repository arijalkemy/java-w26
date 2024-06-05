package org.example;

public class PracticaExcepciones {
    //Atributos
    private int a;
    private int b;

    //Estado inicial de los numeros a evaluar
    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    //Permite calcular la division entre dos numeros enteros
    public void calcular() {
        try {
            if (b == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            System.out.println("La division de "+a+ " entre "+b+" es :"+ a / b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
