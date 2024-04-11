package org.example.ejercicio1.cliente;

import org.example.ejercicio1.transaccion.*;

public class Ejecutivo extends Cliente {
    @Override
    public void realizarDeposito() {
        Deposito deposito = new Deposito();
        deposito.transaccionOK();
    }

    @Override
    public void realizarConsultaDeSaldo() {
        ConsultaDeSaldo consulta = new ConsultaDeSaldo();
        consulta.transaccionNoOK();
    }

    @Override
    public void realizarPagoDeServicios() {
        PagoDeServicios pago = new PagoDeServicios();
        pago.transaccionNoOK();
    }

    @Override
    public void realizarRetiroDeEfectivo() {
        RetiroDeEfectivo retiro = new RetiroDeEfectivo();
        retiro.transaccionNoOK();
    }

    @Override
    public void realizarTransferencia() {
        Transferencia transferencia = new Transferencia();
        transferencia.transaccionOK();
    }
}
