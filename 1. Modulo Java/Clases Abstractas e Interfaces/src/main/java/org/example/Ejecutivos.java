package org.example;

public class Ejecutivos implements ITransacciones{

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no realizada");
    }

    @Override
    public void transaccionOK() {
        System.out.println("Transaccion realizada");
    }

    public void deposito(){
        System.out.println("Deposito realizado");
    }

    public void tranferencia(){
        System.out.println("Transferencia realizada");
    }
}
