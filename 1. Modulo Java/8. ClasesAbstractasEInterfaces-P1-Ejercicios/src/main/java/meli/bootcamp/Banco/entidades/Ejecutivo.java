package meli.bootcamp.Banco.entidades;

import meli.bootcamp.Banco.interfaces.Deposito;
import meli.bootcamp.Banco.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
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
        System.out.println("Transferir");
    }
}
