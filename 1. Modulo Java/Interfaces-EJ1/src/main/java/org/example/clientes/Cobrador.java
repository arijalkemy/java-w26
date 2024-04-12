package org.example.clientes;

import org.example.tiposDeTransacciones.ConsultaSaldo;
import org.example.tiposDeTransacciones.RetiroDinero;

public class Cobrador implements RetiroDinero, ConsultaSaldo {
    @Override
    public void consultarSado() {
        System.out.println("Su saldo es 0 pesos");
    }

    @Override
    public void retirarDinero(int cantidad) {
        System.out.println("No cuenta con fondos suficientes para realizar el retiro");
    }
}
