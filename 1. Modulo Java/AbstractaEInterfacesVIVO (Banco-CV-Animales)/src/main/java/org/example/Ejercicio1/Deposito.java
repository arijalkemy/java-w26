package org.example.Ejercicio1;

public class Deposito implements Transaccion{
    @Override
    public void transaccionOk() {
    System.out.println("Deposito Exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar Deposito");
    }
}
