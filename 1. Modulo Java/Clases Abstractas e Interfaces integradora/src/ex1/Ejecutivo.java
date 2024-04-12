package ex1;

import interfaces.ITransaccion;

public class Ejecutivo implements ITransaccion {
    @Override
    public void transaccionOK() {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no ok");
    }

    public void deposito(){
        System.out.println("Deposito realizado");
    }
    public void transferencia(){
        System.out.println("Realizando transferencia");
    }
}
