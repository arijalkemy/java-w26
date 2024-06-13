package org.example.banco;

import org.example.banco.clientes.Basic;
import org.example.banco.clientes.Cobrador;
import org.example.banco.clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        // Creando un cliente ejecutivo
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();

        // Creando un cliente básico
        Basic basic = new Basic();
        basic.realizarConsultaSaldo();
        basic.realizarPagoServicios();
        basic.realizarRetiroEfectivo();

        // Creando un cobrador
        Cobrador cobrador = new Cobrador();
        cobrador.realizarConsultaSaldo();
        cobrador.realizarRetiroEfectivo();
    }
}