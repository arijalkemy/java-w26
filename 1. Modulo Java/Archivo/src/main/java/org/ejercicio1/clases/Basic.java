package org.ejercicio1.clases;

import org.ejercicio1.interfaces.ConsultaSaldo;
import org.ejercicio1.interfaces.PagoDeServiocio;
import org.ejercicio1.interfaces.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoDeServiocio, RetiroEfectivo {

    @Override
    public void calcularSaldo() {
        System.out.println("Consultando saldo...");
    }

    @Override
    public void pagoDeServiocio(String nombre) {
        System.out.println("Pagando " + nombre);
    }

    @Override
    public void retiroEfectivo(double monto) {
        System.out.println("Retirando $" + monto);
    }
}
