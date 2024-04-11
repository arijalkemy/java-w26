package com.example;

public class PagoDeServicio implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Se ha realizado el pago de servicio con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Ha ocurrido un error al realizar el pago de servicio.");    
    }
    
}
