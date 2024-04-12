package org.bootcamp.cliente;

import org.bootcamp.transaccional.impl.Deposito;
import org.bootcamp.transaccional.impl.Transferencia;

public class Ejecutivo {

    private Deposito deposito;
    private Transferencia transferencia;


    public Ejecutivo() {
        this.deposito = new Deposito();
        this.transferencia = new Transferencia();
    }

    public Deposito depositar(){
        return this.deposito;
    }

    public Transferencia transferir(){
        return this.transferencia;
    }

}
