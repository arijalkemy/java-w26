package org.example.logica;

public class PracticaExcepciones {
    //Atributos
    private int a;
    private int b;

    //Constructor
    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    //Calcula la division entera entre dos numeros
    public void calcular() {
        try {
            if (b == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            System.out.println("La division es: " + (a / b));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
