package org.example;

public class PracticaExcepciones {
    /*
        Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300 de tipo int.
        Calcular el cociente de b/a.
        Controlar la excepción que se lanza indicando el mensaje “Se ha producido un error”.
        Al final del programa siempre deberá indicar el mensaje “Programa finalizado”
     */
    static int a = 0;
    static int b = 300;
    static int cociente;

    public PracticaExcepciones() {
    }

    // Ejercicio 1-1
    public static void dividir() {
        try {
            cociente = b / a;
        } catch (Exception ex) {
            System.out.println("Se a producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    // Ejercicio 1-2
    /*
        Modificar el programa anterior para que, al producirse el error,
        en vez de imprimir por consola el mensaje “Se ha producido un error”,
        lo lance como una excepción de tipo IllegalArgumentException con el mensaje “No se puede dividir por cero”
     */
    public static void dividirConThrow() {
        try {
            if (a==0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            cociente = b / a;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
