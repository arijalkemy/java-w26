package org.example;

public class ConsultaDeSaldo implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Se realizo la consulta de saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realizo la consulta de saldo");
    }
}
