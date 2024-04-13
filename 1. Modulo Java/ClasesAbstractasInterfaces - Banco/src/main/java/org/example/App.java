package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Ejecutivo eje1 = new Ejecutivo();
        eje1.realizarDeposito();
        eje1.realizarTransferencia();

        Basic basic1 = new Basic();
        basic1.consultaDeSaldo();
        basic1.pagoDeServicios();
        basic1.retiroDeEfectivo();

        Cobrador cobr1 = new Cobrador();
        cobr1.consultaDeSaldo();
        cobr1.retiroDeEfectivo();
    }
}
