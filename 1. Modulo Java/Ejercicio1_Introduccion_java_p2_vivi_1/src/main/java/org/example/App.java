package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Declaracion e inicializacion de los numeros a evaluar
        PracticaExcepciones division_1 = new PracticaExcepciones(10, 0);
        division_1.calcular();
        //Declaracion e inicializacion de los numeros a evaluar
        PracticaExcepciones division_2 = new PracticaExcepciones(10, 5);
        division_2.calcular();
    }
}
