package org.ggomezr;

abstract public class Cliente implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Transaccion exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en la transaccion");
    }
}
