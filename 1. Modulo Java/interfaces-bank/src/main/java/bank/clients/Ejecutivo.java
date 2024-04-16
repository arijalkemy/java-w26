package bank.clients;

import bank.transactions.*;

public class Ejecutivo extends Cliente{
    public void realizarDeposito() {
        Deposito deposito = new Deposito();
        deposito.transaccionOk();
    }

    public void realizarTransferencia() {
        Transferencia transferencia = new Transferencia();
        transferencia.transaccionOk();
    }

    public void realizarRetiroDeEfectivo() {
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        retiroEfectivo.transaccionNoOk();
    }

    public void realizarConsultaDeSaldo() {
        ConsultaDeSaldo consultaDeSaldo = new ConsultaDeSaldo();
        consultaDeSaldo.transaccionNoOk();
    }

    public void realizarPagoDeServicios() {
        PagoDeServicios pagoDeServicios = new PagoDeServicios();
        pagoDeServicios.transaccionNoOk();
    }
}
