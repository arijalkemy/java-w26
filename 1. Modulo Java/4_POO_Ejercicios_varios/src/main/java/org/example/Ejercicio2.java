package org.example;

/**
 * La operación realizada en el siguiente programa lanzará una excepción, necesitamos que realices
 * el manejo correspondiente para lograr el siguiente comportamiento:
 * <p>
 * - Permitir la ejecución del código y capturar la excepción lanzada
 * - Imprimir por consola el mensaje de error de la misma al realizar la captura
 * - Imprimir por consola el texto de la variable mensaje Final, de modo tal que se muestre siempre
 *   (es decir, se lance o no una excepción)
 * <p>
 * Pistas:
 * <p>
 * Recuerda que para acceder al mensaje de error de la excepción utilizamos el método .getMessage()
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        // Mensaje final
        String mensajeFinal = "Este es el último mensaje";

        // Código que arroja excepción
        int[] numeros = new int[5];

        try {
            numeros[5] = 10;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println(mensajeFinal);
        }

    }

}
