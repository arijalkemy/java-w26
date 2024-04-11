package org.example.clientes;

import org.example.clientes.Cliente;

import org.example.transferencias.Deposito;
import org.example.transferencias.Transferencia;

public class Ejecutivo extends Cliente {
    @Override
    public void depositar(){
        Deposito t = new Deposito();
        t.transaccionOk();
    }
    @Override
    public void transferir(){
        Transferencia t = new Transferencia();
        t.transaccionOk();
    }
}
