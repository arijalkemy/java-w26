package org.example.ejercicio1;

public class ConsultaDeSaldo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de Saldo realizada con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de Saldo NO realizada");
    }
}
