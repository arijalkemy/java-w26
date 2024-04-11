package com.meli;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("----- Ejecutivo -----");
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.TransaccionOk();
        ejecutivo.deposito();
        ejecutivo.transferencia();

        System.out.println("----- Cobradores -----");
        Cobradores cobradores = new Cobradores();
        cobradores.TransaccionNoOk();
        cobradores.consultarSaldo();
        cobradores.retiro();

        System.out.println("----- Basic -----");
        Basic basic = new Basic();
        basic.consultarSaldo();
        basic.retiro();
    }
}