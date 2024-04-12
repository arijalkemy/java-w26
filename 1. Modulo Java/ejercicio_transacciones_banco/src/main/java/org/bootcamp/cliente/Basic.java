package org.bootcamp.cliente;

import org.bootcamp.transaccional.impl.ConsultaSaldo;
import org.bootcamp.transaccional.impl.PagoServicios;
import org.bootcamp.transaccional.impl.RetiroEfectivo;

public class Basic {

    private PagoServicios pagoServicios;
    private ConsultaSaldo consultaSaldo;
    private RetiroEfectivo retiroEfectivo;

    public Basic() {
        this.consultaSaldo = new ConsultaSaldo();
        this.pagoServicios = new PagoServicios();
        this.retiroEfectivo = new RetiroEfectivo();
    }

    public PagoServicios pagarServicio(){
        return this.pagoServicios;
    }

    public ConsultaSaldo consultarSaldo(){
        return this.consultaSaldo;
    }

    public RetiroEfectivo retirarEfectivo(){
        return this.retiroEfectivo;
    }
}
