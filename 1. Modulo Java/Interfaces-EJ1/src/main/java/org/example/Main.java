package org.example;

import org.example.clientes.Basic;
import org.example.clientes.Cobrador;
import org.example.clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {

        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();

        System.out.println("----------------------------");
        System.out.println("Operaciones de cliente - Ejecutivo");
        ejecutivo.realizarTransacccion(6000, "1324123412");
        ejecutivo.realizarDeposito(23425);

        System.out.println("----------------------------");
        System.out.println("Operaciones de cliente - Basic");
        basic.consultarSado();
        basic.pagarServicio(1341234, "EPS");
        basic.retirarDinero(12341234);

        System.out.println("----------------------------");
        System.out.println("Operaciones de cliente - Cobradores");
        cobrador.consultarSado();
        cobrador.retirarDinero(2341234);
    }
}