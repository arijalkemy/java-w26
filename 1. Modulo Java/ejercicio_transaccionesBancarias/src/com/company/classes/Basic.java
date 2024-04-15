package com.company.classes;

import com.company.interfaces.*;

public class Basic implements IConsultaSaldo, IPagoDeServicios, IRetiroDeEfectivo {
    @Override
    public void transaccionOk() {
        System.out.println("Transacción ok.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción no ok.");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Realizándose consulta de saldo.");
    }

    @Override
    public void realizarPagoDeServicios() {
        System.out.println("Realizándose pago de servicios.");
    }

    @Override
    public void realizarRetiroDeEfectivo() {
        System.out.println("Realizándose retiro de efectivo.");
    }
}
