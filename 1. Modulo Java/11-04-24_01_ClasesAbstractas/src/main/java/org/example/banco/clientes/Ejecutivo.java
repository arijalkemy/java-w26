package org.example.banco.clientes;

import org.example.banco.transacciones.Deposito;
import org.example.banco.transacciones.Transferencia;

public class Ejecutivo {
    private Deposito deposito;
    private Transferencia transferencia;

    public Ejecutivo() {
        this.deposito = new Deposito();
        this.transferencia = new Transferencia();
    }

    public void realizarDeposito() {
        deposito.transaccionOk();
    }

    public void realizarTransferencia() {
        transferencia.transaccionOk();
    }
}
