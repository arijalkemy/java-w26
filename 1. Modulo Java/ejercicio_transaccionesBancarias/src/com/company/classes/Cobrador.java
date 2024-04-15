package com.company.classes;

import com.company.interfaces.IConsultaSaldo;
import com.company.interfaces.IRetiroDeEfectivo;

public class Cobrador implements IRetiroDeEfectivo, IConsultaSaldo {

    @Override
    public void consultarSaldo() {
        System.out.println("Realizándose consulta de saldo.");
    }

    @Override
    public void realizarRetiroDeEfectivo() {
        System.out.println("Realizándose retiro de efectivo.");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción ok.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción no ok.");
    }
}
