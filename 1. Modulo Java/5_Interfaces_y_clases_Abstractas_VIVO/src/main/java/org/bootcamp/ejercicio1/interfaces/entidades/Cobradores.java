package org.bootcamp.ejercicio1.interfaces.entidades;

import org.bootcamp.ejercicio1.interfaces.ConsultaDeSaldo;
import org.bootcamp.ejercicio1.interfaces.RetiroDeEfectivo;

public class Cobradores implements RetiroDeEfectivo, ConsultaDeSaldo {
    public String transaccionOk() {
        return "Transacción OK :)";
    }

    public String transaccionNoOk() {
        return "Transacción no Ok :(";
    }

    public void consultarSaldo() {
        System.out.println("Saldo consultado");
    }
}
