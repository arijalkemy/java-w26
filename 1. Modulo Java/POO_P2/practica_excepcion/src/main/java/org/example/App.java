package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PracticaExcepciones practicaExcepcion = new PracticaExcepciones();

        practicaExcepcion.mostrarExcepecion();

        try{
            practicaExcepcion.lanzarExcepecion();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
