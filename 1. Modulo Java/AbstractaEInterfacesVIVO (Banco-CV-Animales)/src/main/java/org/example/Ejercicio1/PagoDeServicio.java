package org.example.Ejercicio1;

public class PagoDeServicio implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago Exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error");
    }
}
