package com.example;

public class Main {
    public static void main(String[] args) {
        Basic usuarioBasico = new Basic();
        usuarioBasico.consultarSaldo();

        Cobrador usuarioCobrador = new Cobrador();
        usuarioCobrador.retirarEfectivo();
        
        Ejecutivo usuarioEjecutivo = new Ejecutivo();
        usuarioEjecutivo.depositar();
    }
}