package org.example;

import org.example.logica.PracticaExcepciones;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        PracticaExcepciones miDivision = new PracticaExcepciones(10, 2);
        miDivision.calcular();

        PracticaExcepciones miDivision2 = new PracticaExcepciones(10, 0);
        miDivision2.calcular();


    }
}
