package org.bootcamp.ejercicio1.interfaces.entidades;

import org.bootcamp.ejercicio1.interfaces.ConsultaDeSaldo;
import org.bootcamp.ejercicio1.interfaces.PadoDeServicios;
import org.bootcamp.ejercicio1.interfaces.RetiroDeEfectivo;

public class Basic implements ConsultaDeSaldo, PadoDeServicios, RetiroDeEfectivo {
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
    public void retirar() {
        System.out.println("Retiro exitoso");
    }
}
