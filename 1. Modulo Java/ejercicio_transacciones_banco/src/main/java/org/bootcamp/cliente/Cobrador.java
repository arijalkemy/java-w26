package org.bootcamp.cliente;

import org.bootcamp.transaccional.impl.ConsultaSaldo;
import org.bootcamp.transaccional.impl.RetiroEfectivo;

public class Cobrador {
    private RetiroEfectivo retiroEfectivo;
    private ConsultaSaldo consultaSaldo;

    public Cobrador() {
        this.retiroEfectivo = new RetiroEfectivo();
        this.consultaSaldo = new ConsultaSaldo();
    }

    public RetiroEfectivo retirarEfectivo() {
        return retiroEfectivo;
    }

    public ConsultaSaldo consultarSaldo() {
        return consultaSaldo;
    }
}
