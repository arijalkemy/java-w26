package org.example;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Ejecutivo ejecutivo1 = new Ejecutivo();
        ejecutivo1.realizarDeposito(500);
        System.out.println("=======");
        Basic basic1 = new Basic();
        basic1.consultarSaldo();
        basic1.retirarEfectivo(200);
        basic1.pagarServicio("Movistar");
        System.out.println("=======");
        Cobrador cobrador1 = new Cobrador();
        cobrador1.consultarSaldo();
        cobrador1.retirarEfectivo(1000);
        System.out.println("=======");
    }
}
