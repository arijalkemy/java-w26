package org.example;

import org.example.cliente.tipos.Basic;
import org.example.cliente.tipos.Cobrador;
import org.example.cliente.tipos.Ejecutivo;

public class Main {
    public static void main(String[] args) {

        Basic basic = new Basic();
        System.out.println("## Basic ##");
        basic.realizarDeposito();
        basic.realizarTransferencia();
        basic.consultaSaldo();
        basic.pagarServicio();
        basic.realizarDeposito();

        Cobrador cobrador = new Cobrador();
        System.out.println("## Cobrador ##");
        cobrador.realizarDeposito();
        cobrador.realizarTransferencia();
        cobrador.consultaSaldo();
        cobrador.pagarServicio();
        cobrador.realizarDeposito();

        Ejecutivo ejecutivo = new Ejecutivo();
        System.out.println("## Ejecutivo ##");
        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();
        ejecutivo.consultaSaldo();
        ejecutivo.pagarServicio();
        ejecutivo.realizarDeposito();

    }
}