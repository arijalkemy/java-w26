package org.example.clientes;

import org.example.transferencias.Deposito;
import org.example.transferencias.Transferencia;
import org.example.transferencias.RetiroDeEfectivo;
import org.example.transferencias.ConsultaDeSaldo;
import org.example.transferencias.PagoDeServicios;

public abstract class Cliente {
    public void depositar(){
        Deposito t = new Deposito();
        t.transaccionNoOk();
    };
    public void transferir(){
        Transferencia t = new Transferencia();
        t.transaccionNoOk();
    };
    public void retirarEfectivo(){
        RetiroDeEfectivo t = new RetiroDeEfectivo();
        t.transaccionNoOk();
    };
    public void consultarSaldo(){
        ConsultaDeSaldo t = new ConsultaDeSaldo();
        t.transaccionNoOk();
    };
    public void pagarServicios(){
        PagoDeServicios t = new PagoDeServicios();
        t.transaccionNoOk();
    }
}
