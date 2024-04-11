package org.example.transferencias;

public class ConsultaDeSaldo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando consulta de saldo...");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo rechazado.");
    }
}
