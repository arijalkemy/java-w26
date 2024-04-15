package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("---- EJERCICIO DAKAR ----");
        Carrera carrreraDakar = new Carrera(200,3000,"Dakar Race",6);
        carrreraDakar.darDeAltaAuto(120,20,50,"ABC123");
        carrreraDakar.darDeAltaMoto(80,10,10,"ABC231");
        carrreraDakar.darDeAltaAuto(200,10,45,"BCD123");
        carrreraDakar.definirGanador();
    }
}
