package org.example;

/**
 * La operación realizada en el siguiente programa lanzará una excepción, necesitamos que realices
 * el manejo correspondiente para lograr el siguiente comportamiento:
 * - Permitir la ejecución del código y capturar la excepción lanzada
 * - Imprimir por consola el mensaje de error de la misma al realizar la captura
 * - Imprimir por consola el texto de la variable mensaje Final, de modo tal que se muestre siempre
 *   (es decir, se lance o no una excepción)
 * Pistas:
 * Recuerda que para acceder al mensaje de error de la excepción utilizamos el método .getMessage()
 */

public class Ejercicio2 {
        public static void main(String[] args) {
            // Mensaje final
            String mensajeFinal = "Este es el último mensaje";

            try {
                // Código que arroja excepción
                int[] numeros = new int[5];
                numeros[5] = 10;
            } catch (ArrayIndexOutOfBoundsException e) {
                // Capturar la excepción y mostrar el mensaje de error
                System.out.println("Error: " + e.getMessage());
            } finally {
                // Mostrar el mensaje final
                System.out.println(mensajeFinal);
            }
        }
    }
