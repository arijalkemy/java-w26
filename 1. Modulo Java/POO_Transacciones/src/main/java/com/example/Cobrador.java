package com.example;

public class Cobrador {
    
    Transaccion transaccion;

    public void retirarEfectivo(){
        this.transaccion = new RetiroEnEfectivo();
        this.transaccion.transaccionOk();
    }
    
    public void consultarSaldo(){
        this.transaccion = new ConsultaDeSaldo();
        this.transaccion.transaccionOk();
    }
}
