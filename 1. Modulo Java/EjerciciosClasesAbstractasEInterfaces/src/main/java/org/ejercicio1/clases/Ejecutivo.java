package org.ejercicio1.clases;

import org.ejercicio1.interfaces.Deposito;
import org.ejercicio1.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    @Override
    public void depositar(double monto) {
        System.out.println("Depositando $" + monto);
    }

    @Override
    public void trasnferir(double monto, String cuentaDestino) {
        System.out.println("Transfiriendo $" + monto + " a " + cuentaDestino);
    }
}
