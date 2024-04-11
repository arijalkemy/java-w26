package org.example.ejercicio1.transaccion;

public class ConsultaDeSaldo implements ITransaccion {
    @Override
    public void transaccionOK() {
        System.out.println("Realizando consulta de saldo");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("No se puede realizar la consulta de saldo");
    }
}
