package org.ggomezr;

public class Banco {
    public static void main(String[] args) {
        System.out.println("\n----- Ejecutivo -----\n");

        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.depositar();
        ejecutivo.transferir();

        System.out.println("\n----- Basic -----\n");

        Basic basic = new Basic();
        basic.consultarSaldo();
        basic.pagarServicio();
        basic.retirarEfectivo();

        System.out.println("\n----- Cobrador -----\n");

        Cobrador cobrador = new Cobrador();
        cobrador.retiroEfectivo();
        cobrador.consultarSaldo();
    }
}
