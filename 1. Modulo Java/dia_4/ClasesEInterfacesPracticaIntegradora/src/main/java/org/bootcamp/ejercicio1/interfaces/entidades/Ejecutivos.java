package org.bootcamp.ejercicio1.interfaces.entidades;

import org.bootcamp.ejercicio1.interfaces.Deposito;
import org.bootcamp.ejercicio1.interfaces.Transferencia;

public class Ejecutivos implements Deposito, Transferencia {
    public String transaccionOk() {
        return "Transacción OK :)";
    }

    public String transaccionNoOk() {
        return "Transacción no Ok :(";
    }

    public void depositar() {
        System.out.println("Deposito realizado");
    }

    public void transferir() {

    }
}
