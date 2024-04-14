package org.example.model;

public class ConsultaDeSaldo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo no realizado");
    }

}
