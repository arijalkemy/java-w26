package org.example.ejercicio_1;

public class Ejecutivo extends Cliente {
    public void depositar() {
        ITransaccion transferencia = new Deposito();
        // if deposito OK
        transferencia.transaccionOk();
        // else
        transferencia.transaccionNoOk();
    }

    public void transferir() {
        ITransaccion transferencia = new Transferencia();
        // if transferencia OK
        transferencia.transaccionOk();
        // else
        transferencia.transaccionNoOk();
    }
}
