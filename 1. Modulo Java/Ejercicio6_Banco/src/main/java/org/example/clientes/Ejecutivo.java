package org.example.clientes;

import org.example.tiposDeTransacciones.IDeposito;
import org.example.tiposDeTransacciones.ITransferencia;

public class Ejecutivo implements IDeposito, ITransferencia {
    @Override
    public void realizarDeposito(int dinero) {
        System.out.println("Dinero depositado con éxito");
    }

    @Override
    public void realizarTransacccion(int money, String numCuenta) {
        System.out.println("Transacción realizada con éxito");
    }
}
