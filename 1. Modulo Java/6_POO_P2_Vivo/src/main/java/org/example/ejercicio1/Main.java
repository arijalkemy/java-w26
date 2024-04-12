package org.example.ejercicio1;

/**
 * 1)
 * Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300 de tipo int.
 * Calcular el cociente de b/a.
 * Controlar la excepción que se lanza indicando el mensaje “Se ha producido un error”.
 * Al final del programa siempre deberá indicar el mensaje “Programa finalizado”
 * <p>
 * 2)
 * Modificar el programa anterior para que, al producirse el error, en vez de imprimir por consola el mensaje
 * “Se ha producido un error”, lo lance como una excepción de tipo IllegalArgumentException
 * con el mensaje “No se puede dividir por cero”.
 */
public class Main
{
    public static void main( String[] args )
    {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();

        try {
            int cociente = practicaExcepciones.getB() / practicaExcepciones.getA();
            System.out.println("Cociente entre b y a: " + cociente);
        }
        catch (ArithmeticException ignored) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
}
