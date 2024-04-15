package org.example.ejercicio1;

public class Cobradores extends Cliente{

    @Override
    public void retirarEfectivo() {
        super.retirarEfectivo();
        transaccion.transaccionOk();
    }

    @Override
    public void realizarDeposito() {
        super.realizarDeposito();
        transaccion.transaccionNoOk();
    }

    @Override
    public void realizarTransferencia() {
        super.realizarTransferencia();
        transaccion.transaccionNoOk();
    }

    @Override
    public void realizarConsultaDeSaldo() {
        super.realizarConsultaDeSaldo();
        transaccion.transaccionOk();
    }

    @Override
    public void realizarPagoDeServicios() {
        super.realizarPagoDeServicios();
        transaccion.transaccionNoOk();
    }
}
