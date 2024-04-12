package org.example.clientes;

import org.example.tiposDeTransacciones.Deposito;
import org.example.tiposDeTransacciones.Transaccion;
import org.example.tiposDeTransacciones.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void realizarDeposito(int dinero) {
        System.out.println("Dinero depositado con éxito");
    }

    @Override
    public void realizarTransacccion(int money, String numCuenta) {
        System.out.println("Transacción realizada con éxito");
    }
}
