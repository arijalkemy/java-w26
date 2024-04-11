package org.example.clientes;

import org.example.acciones.Deposito;
import org.example.acciones.Transferencia;
import org.example.interfaces.IDeposito;
import org.example.interfaces.ITransferencia;

public class Ejecutivo implements IDeposito, ITransferencia {

    public Ejecutivo() {

    }

    public void depositar(){
        Deposito deposito = new Deposito();
        deposito.transaccionOk();
    }

    public void transferir(){
        Transferencia transferencia = new Transferencia();
        transferencia.transaccionNoOk();
    }

}
