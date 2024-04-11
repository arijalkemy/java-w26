package meli.bootcamp.Banco.entidades;

import meli.bootcamp.Banco.interfaces.RetiroDeEfectivo;
import meli.bootcamp.Banco.interfaces.ConsultaDeSaldo;

public class Cobrador implements RetiroDeEfectivo, ConsultaDeSaldo {
    public String transaccionOk() {
        return "Transacción OK :)";
    }

    public String transaccionNoOk() {
        return "Transacción no Ok :(";
    }

    public void consultarSaldo() {
        System.out.println("Saldo consultado");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retiro efectivo");
    }
}
