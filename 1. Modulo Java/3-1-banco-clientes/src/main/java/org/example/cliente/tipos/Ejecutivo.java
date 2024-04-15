package org.example.cliente.tipos;

import org.example.cliente.Cliente;
import org.example.transaccion.impl.*;

public class Ejecutivo extends Cliente {

    @Override
    public void realizarDeposito() {
        Deposito deposito = new Deposito();
        deposito.transaccionOK();
    }

    @Override
    public void realizarTransferencia() {
        Transferencia transferencia = new Transferencia();
        transferencia.transaccionOK();
    }

    @Override
    public void consultaSaldo() {
        ConsultaSaldo saldo = new ConsultaSaldo();
        saldo.transaccionNoOk();
    }

    @Override
    public void pagarServicio() {
        PagoServicio pago = new PagoServicio();
        pago.transaccionNoOk();
    }

    @Override
    public void retirarEfectivo() {
        RetirarEfectivo retiro = new RetirarEfectivo();
        retiro.transaccionNoOk();
    }
}
