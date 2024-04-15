package org.example;

public class Ejecutivo implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Ejecutivo: la transaccion fue ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Ejecutivo: la transaccion no fue ok");
    }

    public void realizarDeposito(){
        System.out.println("Ejecutivo: deposito en proceso");
        transaccionNoOk();
    }

    public void realizarTransferencia() {
        System.out.println("Ejecutivo: trasnferencia en proceso");
        transaccionOk();
    }

}
