package com.bootcamp.transacciones;

import com.bootcamp.transacciones.clientes.Basic;

public class App {
    public static void main( String[] args ) {
        System.out.println("Banco");
        Basic basic = new Basic();
        basic.consultarSaldo("1234567890");
        basic.transaccionOk("Consulta de saldo");
        basic.pagarServicio("Agua", 100.0);
        basic.transaccionOk("Pago de servicio");
        basic.retirar("1234567890", 200.0);

    }
}
