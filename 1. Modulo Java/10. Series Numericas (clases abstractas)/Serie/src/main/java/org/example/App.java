package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SerieDeDos dos = new SerieDeDos(2);
        dos.valorInicialSerie(1);
        dos.valorSiguiente();
        dos.valorSiguiente();
        dos.valorSiguiente();

        SerieDeTres tres = new SerieDeTres(3);
        tres.valorInicialSerie(1);
        tres.valorSiguiente();
        tres.valorSiguiente();
        tres.valorSiguiente();
    }
}
