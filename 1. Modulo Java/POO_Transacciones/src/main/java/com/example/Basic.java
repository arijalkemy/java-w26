package com.example;

public class Basic {

    Transaccion transaccion;

    public void consultarSaldo(){
        this.transaccion = new ConsultaDeSaldo();
        this.transaccion.transaccionOk();
    }

    public void pagarServicio(){
        this.transaccion = new PagoDeServicio();
        this.transaccion.transaccionOk();
    }

    public void retirarEfectivo(){
        this.transaccion = new RetiroEnEfectivo();
        this.transaccion.transaccionOk();
    }
}
