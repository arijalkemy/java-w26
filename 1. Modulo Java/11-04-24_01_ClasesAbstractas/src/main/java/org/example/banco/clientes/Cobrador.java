package org.example.banco.clientes;

import org.example.banco.transacciones.ConsultaSaldo;
import org.example.banco.transacciones.RetiroEfectivo;

public class Cobrador {
    private ConsultaSaldo consultaSaldo;
    private RetiroEfectivo retiroEfectivo;

    public Cobrador() {
        this.consultaSaldo = new ConsultaSaldo();
        this.retiroEfectivo = new RetiroEfectivo();
    }

    public void realizarConsultaSaldo() {
        consultaSaldo.transaccionOk();
    }

    public void realizarRetiroEfectivo() {
        retiroEfectivo.transaccionOk();
    }
}
