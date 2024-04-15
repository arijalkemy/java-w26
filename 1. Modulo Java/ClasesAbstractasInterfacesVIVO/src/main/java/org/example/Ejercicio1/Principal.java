package org.example.Ejercicio1;

public class Principal {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo("Juan");
        Cobrador cobrador = new Cobrador("Pedro");
        Basic basic = new Basic("Maria");
        ejecutivo.depositar(1000);
        cobrador.consultarSaldo();
        basic.retirar();
    }
}
