package org.ejerciciouno.entities.clientes;

import org.ejerciciouno.interfaces.ITransaccion;

public class Cobrador {
    ITransaccion consultaSaldo;
    ITransaccion retirarEfectivo;

    public Cobrador(ITransaccion consultaSaldo, ITransaccion retirarEfectivo) {
        this.consultaSaldo = consultaSaldo;
        this.retirarEfectivo = retirarEfectivo;
    }

    public void realizarConsultaSaldo(){
        int rand = (int) Math.round(Math.random());
        if(rand == 0) {
            this.consultaSaldo.transaccionNoOk();
            return;
        }
        this.consultaSaldo.transaccionOk();
    }

    public void realizarRetiroEfectivo(){
        int rand = (int) Math.round(Math.random());
        if(rand == 0) {
            this.retirarEfectivo.transaccionNoOk();
            return;
        }
        this.retirarEfectivo.transaccionOk();
    }
}
