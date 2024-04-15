package org.example.ejercicio_1;

public class Basic extends Cliente {
    public void consultarSaldo() {
        ITransaccion transferencia = new ConsultaDeSaldos();
        // if consulta de saldo OK
        transferencia.transaccionOk();
        // else
        transferencia.transaccionNoOk();
    }

    public void pagarServicios() {
        ITransaccion transferencia = new PagoDeServicios();
        // if pago de servicios OK
        transferencia.transaccionOk();
        // else
        transferencia.transaccionNoOk();
    }

    public void retirarEfectivo() {
        ITransaccion transferencia = new RetiroDeEfectivo();
        // if retiro de efectivo OK
        transferencia.transaccionOk();
        // else
        transferencia.transaccionNoOk();
    }
}
