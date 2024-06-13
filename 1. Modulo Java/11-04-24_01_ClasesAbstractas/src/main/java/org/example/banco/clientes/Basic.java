package org.example.banco.clientes;

import org.example.banco.transacciones.ConsultaSaldo;
import org.example.banco.transacciones.PagoServicios;
import org.example.banco.transacciones.RetiroEfectivo;

public class Basic {
    private ConsultaSaldo consultaSaldo;
    private PagoServicios pagoServicios;
    private RetiroEfectivo retiroEfectivo;

    public Basic() {
        this.consultaSaldo = new ConsultaSaldo();
        this.pagoServicios = new PagoServicios();
        this.retiroEfectivo = new RetiroEfectivo();
    }

    public void realizarConsultaSaldo() {
        consultaSaldo.transaccionOk();
    }

    public void realizarPagoServicios() {
        pagoServicios.transaccionOk();
    }

    public void realizarRetiroEfectivo() {
        retiroEfectivo.transaccionOk();
    }
}
