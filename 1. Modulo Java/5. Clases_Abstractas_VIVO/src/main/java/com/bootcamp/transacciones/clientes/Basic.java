package com.bootcamp.transacciones.clientes;

import com.bootcamp.transacciones.transaccion.*;

public class Basic implements ConsultaDeSaldo, PagoDeServicio, RetiroDeEfectivo {

    @Override
    public void consultarSaldo(String cuenta) {
        System.out.println("Consulta de saldo de la cuenta " + cuenta + " realizada");
    }

    @Override
    public void pagarServicio(String servicio, double monto) {
        System.out.println("Pago de servicio " + servicio + " por " + monto + " realizado");
    }

    @Override
    public void retirar(String cuenta, double monto) {
        System.out.println("Retiro de " + monto + " de la cuenta " + cuenta + " realizado");
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
