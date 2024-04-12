package org.example;


public class App 
{
    public static void main( String[] args )
    {
        Serie1 serieEjemplo = new Serie1();
        serieEjemplo.iniciarSerie(3);
        System.out.println(serieEjemplo.numeroSiguiente());
        System.out.println(serieEjemplo.numeroSiguiente());
        System.out.println(serieEjemplo.numeroSiguiente());
        System.out.println(serieEjemplo.numeroSiguiente());
        System.out.println(serieEjemplo.numeroSiguiente());
        System.out.println(serieEjemplo.reiniciarSerie());
    }
}
