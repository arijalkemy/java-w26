package org.example;

import org.example.clientes.Ejecutivo;

public class App
{
    public static void main( String[] args )
    {
        Ejecutivo ejecutivo = new Ejecutivo();

        ejecutivo.transferir();
        ejecutivo.depositar();
    }
}
