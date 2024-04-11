package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Basic basic = new Basic();
        basic.consultaSaldo();
        basic.pagoServicios();
        basic.retiroEfectivo();

        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.deposito();
    }
}
