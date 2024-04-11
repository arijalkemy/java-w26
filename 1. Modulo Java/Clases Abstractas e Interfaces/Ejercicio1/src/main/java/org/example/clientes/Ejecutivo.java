package org.example;

public class Ejecutivo extends Cliente{
    @Override
    public void depositar(){
        Deposito t = new Deposito();
        t.transaccionOk();
    }
    @Override
    public void transferir(){
        Deposito t = new Deposito();
        t.transaccionOk();
    }
}
