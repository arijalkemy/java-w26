package org.example;

import org.example.cliente.Basic;
import org.example.cliente.Cobrador;
import org.example.cliente.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic("Matias", "40000000");
        Ejecutivo ejecutivo = new Ejecutivo("Nicolas", "39999999");
        Cobrador cobrador = new Cobrador("Jose", "40000000");

        ejecutivo.realizarDeposito(200);
        ejecutivo.transaccionOk();
        System.out.println("-----------");
        cobrador.retirarEfectivo(300);
        cobrador.transaccionNoOk();
        System.out.println("-----------");
    }
}