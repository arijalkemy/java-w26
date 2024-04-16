package bank.clients;

import bank.transactions.Deposito;
import bank.transactions.Transaccion;

public abstract class Cliente {
    public Cliente() {
    }

    public abstract void realizarDeposito();
    public abstract void realizarTransferencia();
    public abstract void realizarRetiroDeEfectivo();
    public abstract void realizarConsultaDeSaldo();
    public abstract void realizarPagoDeServicios();
}
