package org.example.ejercicio1.cliente;

import org.example.ejercicio1.transaccion.*;

public class Basic extends Cliente {
    @Override
    public void realizarDeposito() {
        Deposito deposito = new Deposito();
        deposito.transaccionNoOK();
    }

    @Override
    public void realizarConsultaDeSaldo() {
        ConsultaDeSaldo saldo = new ConsultaDeSaldo();
        saldo.transaccionOK();
    }

    @Override
    public void realizarPagoDeServicios() {
        PagoDeServicios pago = new PagoDeServicios();
        pago.transaccionOK();
    }

    @Override
    public void realizarRetiroDeEfectivo() {
        RetiroDeEfectivo retiro = new RetiroDeEfectivo();
        retiro.transaccionOK();
    }

    @Override
    public void realizarTransferencia() {
        Transferencia transferencia = new Transferencia();
        transferencia.transaccionNoOK();
    }
}
