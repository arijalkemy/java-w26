package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.depositar();
        Basic basic = new Basic();
        basic.consultarSaldo();
    }
}
