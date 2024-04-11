package org.example.clientes;

import org.example.transferencias.RetiroDeEfectivo;
import org.example.transferencias.ConsultaDeSaldo;

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
