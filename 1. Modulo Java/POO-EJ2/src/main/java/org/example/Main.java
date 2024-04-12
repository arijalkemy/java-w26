package org.example;

import org.example.clases.Excepciones;

public class Main
{
    public static void main( String[] args )
    {
        Excepciones practicaExcepciones = new Excepciones();

        // Variante 1
        practicaExcepciones.calcularCociente();

        // Variante 2
        try{
            practicaExcepciones.calcularCocienteVariante2();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
