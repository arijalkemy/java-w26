package com.meli;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();
        Ejecutivos ejecutivos = new Ejecutivos();

        System.out.println("Se van a imprimir los metodos de Basic"+"\n");

        basic.transaccionOk();
        basic.transaccionNoOk();
        basic.retirarEfectivo();
        basic.pagarServicio();
        basic.consultarSaldo();

        System.out.println("\n"+ "Se van a imprimir los metodos de Cobrador"+"\n");

        cobrador.transaccionOk();
        cobrador.transaccionNoOk();
        cobrador.consultarSaldo();
        cobrador.retirarEfectivo();

        System.out.println("\n"+"Se van a imprimir los metodos de Ejecutivos"+"\n");

        ejecutivos.transaccionOk();
        ejecutivos.transaccionNoOk();
        ejecutivos.deposito();
        ejecutivos.transferencia();

    }
}
