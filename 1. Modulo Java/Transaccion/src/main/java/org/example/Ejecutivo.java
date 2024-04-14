package org.example;

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
