package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones(0,300);
        try {
            practicaExcepciones.calcularCociente();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }

    }
}
