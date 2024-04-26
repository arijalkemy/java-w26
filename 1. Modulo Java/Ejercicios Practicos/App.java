package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PracticaExcepciones prac = new PracticaExcepciones();
        try{
            prac.calcularCociente();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
