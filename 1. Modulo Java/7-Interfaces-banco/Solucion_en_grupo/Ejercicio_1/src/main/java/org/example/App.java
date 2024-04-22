package org.example;

public class App 
{
    public static void main( String[] args )
    {
        Cliente ejecutivo = new Ejecutivo("Joaquin Oldani");

        ejecutivo.transferir();
        ejecutivo.depositar();
    }
}
