package org.bootcamp;

import org.bootcamp.ejercicio1.interfaces.entidades.Basic;
import org.bootcamp.ejercicio1.interfaces.entidades.Cobradores;
import org.bootcamp.ejercicio1.interfaces.entidades.Ejecutivos;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Basic basic = new Basic();
        basic.consultarSaldo();
        basic.transaccionNoOk();

        Cobradores cobradores = new Cobradores();
        cobradores.consultarSaldo();
        cobradores.transaccionNoOk();

        Ejecutivos ejecutivos = new Ejecutivos();
        ejecutivos.depositar();
        ejecutivos.depositar();
        ejecutivos.transferir();
        ejecutivos.transaccionOk();
    }
}
