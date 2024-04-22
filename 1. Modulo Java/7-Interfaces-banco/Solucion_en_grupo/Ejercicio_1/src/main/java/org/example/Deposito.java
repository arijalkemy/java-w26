package org.example;

public class Deposito implements ITransaccion{
    public void transaccionOk() {
        System.out.println("El deposito se realizo correctamente");
    }

    public void transaccionNoOk() {
        System.out.println("El deposito no se realizo correctamente");
    }
}
