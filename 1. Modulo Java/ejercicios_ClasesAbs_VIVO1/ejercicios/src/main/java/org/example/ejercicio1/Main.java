package org.example.ejercicio1;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        /*
        * Transacciones con ejecutivo
        * */
        System.out.println("Ejecutivo ");
        Ejecutivos e = new Ejecutivos();
        e.realizarDeposito();
        e.realizarConsultaDeSaldo();
        e.realizarPagoDeServicios();
        e.retirarEfectivo();
        e.realizarTransferencia();

        System.out.println("Basic");
        Basic b = new Basic();

        b.realizarDeposito();
        b.realizarConsultaDeSaldo();
        b.realizarPagoDeServicios();
        b.retirarEfectivo();
        b.realizarTransferencia();

        System.out.println("Cobradores");
        Cobradores c = new Cobradores();
        c.realizarDeposito();
        c.realizarConsultaDeSaldo();
        c.realizarPagoDeServicios();
        c.retirarEfectivo();
        c.realizarTransferencia();
    }
}
