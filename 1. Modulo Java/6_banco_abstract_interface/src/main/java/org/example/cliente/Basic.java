package org.example.cliente;

import org.example.transaccion.ConsultaSaldo;
import org.example.transaccion.PagoServicio;
import org.example.transaccion.RetirarEfectivo;

public class Basic extends Cliente implements ConsultaSaldo, PagoServicio, RetirarEfectivo {

    public Basic(String nombre, String dni) {
        super(nombre, dni);
    }

    @Override
    public void pagarServicio(String servicio) {
        System.out.println("Pagar servicio: " + servicio);
    }

    @Override
    public void retirarEfectivo(double dinero) {
        System.out.println("Retirando efectivo: " + dinero);
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion desde BASIC OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion desde BASIC NO OK");
    }

    @Override
    public void consultarSaldo() {
        // Pruebo de consultar al default de la interface
        ConsultaSaldo.super.consultarSaldo();
    }
}
