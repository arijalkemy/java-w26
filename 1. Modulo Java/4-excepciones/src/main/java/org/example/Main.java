package org.example;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {

        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();

        //Punto 1

        try {
            practicaExcepciones.calcularCociente();
        } catch (ArithmeticException er) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }

        //Punto 2

        try {
            practicaExcepciones.calcularCociente();
        } catch (ArithmeticException er) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }


    }
}
