package com.bootcamp.transacciones.clientes;

import com.bootcamp.transacciones.transaccion.Deposito;
import com.bootcamp.transacciones.transaccion.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    @Override
    public void depositar(String cuenta, double monto) {
        System.out.println("Deposito de " + monto + " a la cuenta " + cuenta + " realizado");
    }

    @Override
    public void transferir(String cuentaOrigen, String cuentaDestino, double monto) {
        System.out.println("Transferencia de " + monto + " de la cuenta " + cuentaOrigen + " a la cuenta " + cuentaDestino + " realizada");
    }

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("Transaccion de tipo " + tipoTransaccion + " realizada con exito");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("Transaccion de tipo " + tipoTransaccion + " no realizada");
    }
}
