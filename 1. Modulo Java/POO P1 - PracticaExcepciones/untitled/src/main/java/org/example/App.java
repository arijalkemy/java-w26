package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();

        // Ejercicio 1.
        practicaExcepciones.calcularCocienteUno();

        try {
            // Ejercicio 2. Se agrego dentro de un try catch para imprimir el mensaje de error.
            practicaExcepciones.calcularCocienteDos();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
