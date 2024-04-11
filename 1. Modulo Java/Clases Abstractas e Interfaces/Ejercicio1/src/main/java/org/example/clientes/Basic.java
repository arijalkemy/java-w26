package org.example;

public class Basic extends Cliente {
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
    @Override
    public void pagarServicios(){
        PagoDeServicios t = new PagoDeServicios();
        t.transaccionOk();
    }
}
