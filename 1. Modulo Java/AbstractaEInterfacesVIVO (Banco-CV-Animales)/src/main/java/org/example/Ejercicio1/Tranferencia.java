package org.example.Ejercicio1;

public class Tranferencia implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Tranferencia Exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("error al transferir");
    }
}
