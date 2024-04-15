package org.example.clases;

public class Main {
    public static void main(String[] args) {
        // Se ejecuta una prueba
        Ejecutivo ejecutivo = new Ejecutivo();

        ejecutivo.hacerDeposito();
        ejecutivo.transaccionOk();
        // Se ejecuta una pruba con un cobrador
        Cobrador cobrador = new Cobrador();

        cobrador.hacerConsultaDeSaldo();
        cobrador.transaccionNoOk();
        // Se ejecuta  una prueba con un Basic

        Basic basic = new Basic();
        basic.hacerPagoDeServicio();
        basic.transaccionOk();

    }
}
