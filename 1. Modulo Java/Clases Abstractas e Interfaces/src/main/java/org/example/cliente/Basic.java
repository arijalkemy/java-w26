package org.example.cliente;

import org.example.transaccion.ConsultaSaldo;
import org.example.transaccion.PagoServicios;
import org.example.transaccion.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoServicios, RetiroEfectivo {

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion ok");
    }
    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no ok");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo:");
    }

    @Override
    public void pagarServicios() {
        System.out.println("Servicios pagados");
    }
    @Override
    public void retirarEfectivo() {
        System.out.println("Se retiro el efectivo");
    }
}
