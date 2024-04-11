package org.example;

public class Cobrador extends Cliente{
    @Override
    public void retirarEfectivo(){
        RetiroDeEfectivo t = new RetiroDeEfectivo();
        t.transaccionOk();
    };
    @Override
    public void consultarSaldo(){
        ConsultaDeSaldo t = new ConsultaDeSaldo();
        t.transaccionOk();
    };
}
