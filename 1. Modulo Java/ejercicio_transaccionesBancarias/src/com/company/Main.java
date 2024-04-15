package com.company;

import com.company.classes.Basic;
import com.company.classes.Cobrador;
import com.company.classes.Ejecutivo;

public class Main {

    public static void main(String[] args) {

        // Se instancian los objetos
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        // Se ejecutan los métodos de cada cliente
        basic.consultarSaldo();
        basic.transaccionOk();

        basic.realizarPagoDeServicios();
        basic.transaccionNoOk();

        cobrador.realizarRetiroDeEfectivo();
        cobrador.transaccionOk();

        ejecutivo.realizarDeposito();
        ejecutivo.transaccionNoOk();

        ejecutivo.realizarTransferencia();
        ejecutivo.transaccionOk();
    }
}
