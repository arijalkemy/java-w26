package org.example;

public class ConsultaSaldo implements Transaccion{
    @Override
    public void TransaccionOk() {
        System.out.println("Consulta exitoso");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Consulta no exitoso");
    }
}
