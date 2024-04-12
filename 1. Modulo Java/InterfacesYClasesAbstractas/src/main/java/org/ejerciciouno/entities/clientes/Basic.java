package org.ejerciciouno.entities.clientes;

import org.ejerciciouno.interfaces.ITransaccion;

public class Basic {
    ITransaccion consultaSaldo;
    ITransaccion pagoServicios;
    ITransaccion retiroEfectivo;

    public Basic(ITransaccion consultaSaldo, ITransaccion pagoServicios, ITransaccion retiroEfectivo) {
        this.consultaSaldo = consultaSaldo;
        this.pagoServicios = pagoServicios;
        this.retiroEfectivo = retiroEfectivo;
    }

    public void realizarConsultaSaldo(){
        int rand = (int) Math.round(Math.random());
        if(rand == 0) {
            this.consultaSaldo.transaccionNoOk();
            return;
        }
        this.consultaSaldo.transaccionOk();
    }

    public void realizarPagoDeServicios(){
        int rand = (int) Math.round(Math.random());
        if(rand == 0) {
            this.pagoServicios.transaccionNoOk();
            return;
        }
        this.pagoServicios.transaccionOk();
    }

    public void realizarRetiroEfectivo(){
        int rand = (int) Math.round(Math.random());
        if(rand == 0) {
            this.retiroEfectivo.transaccionNoOk();
            return;
        }
        this.retiroEfectivo.transaccionOk();
    }
}
