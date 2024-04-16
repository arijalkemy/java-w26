package org.example.Ejercicio1;

public class RetiroDeEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro Exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se puede transferir");
    }
}
