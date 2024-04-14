package org.example.clientes;

import org.example.tiposDeTransacciones.IConsultaSaldo;
import org.example.tiposDeTransacciones.IRetiroDinero;

public class Cobrador implements IRetiroDinero, IConsultaSaldo {
    @Override
    public void consultarSado() {
        System.out.println("Su saldo es 0 pesos");
    }

    @Override
    public void retirarDinero(int cantidad) {
        System.out.println("No cuenta con fondos suficientes para realizar el retiro");
    }
}
