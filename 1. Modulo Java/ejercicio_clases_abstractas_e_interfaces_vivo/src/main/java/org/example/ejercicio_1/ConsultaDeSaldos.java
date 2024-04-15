package org.example.ejercicio_1;

public class ConsultaDeSaldos implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de Saldo OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de Saldo No OK");
    }
}
