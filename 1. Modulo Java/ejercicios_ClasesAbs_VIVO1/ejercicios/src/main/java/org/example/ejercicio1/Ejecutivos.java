package org.example.ejercicio1;

public class Ejecutivos extends Cliente{
    @Override
    public void retirarEfectivo() {
        super.retirarEfectivo();
        transaccion.transaccionNoOk();
    }

    @Override
    public void realizarDeposito() {
        super.realizarDeposito();
        transaccion.transaccionOk();
    }

    @Override
    public void realizarTransferencia() {
        super.realizarTransferencia();
        transaccion.transaccionOk();
    }

    @Override
    public void realizarConsultaDeSaldo() {
        super.realizarConsultaDeSaldo();
        transaccion.transaccionNoOk();
    }

    @Override
    public void realizarPagoDeServicios() {
        super.realizarPagoDeServicios();
        transaccion.transaccionNoOk();
    }
}
