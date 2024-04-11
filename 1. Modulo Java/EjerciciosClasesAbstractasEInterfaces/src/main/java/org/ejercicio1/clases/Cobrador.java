package org.ejercicio1.clases;

import org.ejercicio1.interfaces.ConsultaSaldo;
import org.ejercicio1.interfaces.RetiroEfectivo;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo {
    @Override
    public void calcularSaldo() {
        System.out.println("Consultando saldo...");
    }

    @Override
    public void retiroEfectivo(double monto) {
        System.out.println("Retirando $" + monto);
    }
}
