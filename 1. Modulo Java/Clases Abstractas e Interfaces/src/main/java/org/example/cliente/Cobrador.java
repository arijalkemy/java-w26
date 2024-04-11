package org.example.cliente;

import org.example.transaccion.ConsultaSaldo;
import org.example.transaccion.RetiroEfectivo;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo {
    @Override
    public void consultarSaldo() {
        System.out.println("Saldo:");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Efectivo retirado");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en la transaccion");
    }
}
