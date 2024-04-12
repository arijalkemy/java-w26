package org.ejerciciouno.entities.clientes;

import org.ejerciciouno.interfaces.ITransaccion;

public class Ejecutivo {
    ITransaccion deposito;
    ITransaccion transferencia;

    public Ejecutivo(ITransaccion deposito, ITransaccion transferencia) {
        this.deposito = deposito;
        this.transferencia = transferencia;
    }

    public void realizarDeposito(){
        int rand = (int) Math.round(Math.random());
        if(rand == 0) {
            this.deposito.transaccionNoOk();
            return;
        }
        this.deposito.transaccionOk();
    }

    public void realizarTransferencia(){
        int rand = (int) Math.round(Math.random());
        if(rand == 0) {
            this.transferencia.transaccionNoOk();
            return;
        }
        this.transferencia.transaccionOk();
    }
}
