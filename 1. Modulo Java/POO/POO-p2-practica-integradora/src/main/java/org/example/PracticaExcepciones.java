package org.example;

public class PracticaExcepciones {
    int a;
    int b;
    int cociente;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // Ejercicio 1-1
    public void dividir() {

        try {
            cociente = this.a / this.b;
        } catch (Exception ex) {
            System.out.println("Se a producido un error");
        } finally {
            System.out.println("Programa finalizo");
        }
    }
    // Ejercicio 1-2
    public void dividirConThrow() {

        try {
            cociente = this.a / this.b;
        } catch (Exception ex) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizo");
        }
    }
}
