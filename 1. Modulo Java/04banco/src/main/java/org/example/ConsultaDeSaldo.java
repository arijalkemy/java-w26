package org.example;

public class ConsultaDeSaldo implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Consulta de Saldo Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de Saldo No Ok");
    }
}

