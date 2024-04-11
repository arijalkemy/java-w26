package org.example.cliente.tipos;

import org.example.cliente.Cliente;
import org.example.transaccion.impl.Deposito;
import org.example.transaccion.impl.Transferencia;
import org.example.transaccion.impl.ConsultaSaldo;
import org.example.transaccion.impl.PagoServicio;
import org.example.transaccion.impl.RetirarEfectivo;

public class Basic extends Cliente {

    @Override
    public void realizarDeposito() {
        Deposito deposito = new Deposito();
        deposito.transaccionNoOk();
    }

    @Override
    public void realizarTransferencia() {
        Transferencia transferencia = new Transferencia();
        transferencia.transaccionNoOk();
    }

    @Override
    public void consultaSaldo() {
        ConsultaSaldo saldo = new ConsultaSaldo();
        saldo.transaccionOK();
    }

    @Override
    public void pagarServicio() {
        PagoServicio pago = new PagoServicio();
        pago.transaccionOK();
    }

    @Override
    public void retirarEfectivo() {
        RetirarEfectivo retiro = new RetirarEfectivo();
        retiro.transaccionOK();
    }


}
