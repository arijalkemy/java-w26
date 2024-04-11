package meli.bootcamp.Banco.entidades;

import meli.bootcamp.Banco.interfaces.RetiroDeEfectivo;
import meli.bootcamp.Banco.interfaces.ConsultaDeSaldo;
import meli.bootcamp.Banco.interfaces.PagoDeServicios;

public class Basic implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo {
    public String transaccionOk() {
        return "Transacción OK :)";
    }

    public String transaccionNoOk() {
        return "Transacción no Ok :(";
    }

    public void consultarSaldo() {
        System.out.println("Saldo consultado");
    }

    public void pagarServicio() {
        System.out.println("Servicio pagado");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retiro efectivo");
    }
}
