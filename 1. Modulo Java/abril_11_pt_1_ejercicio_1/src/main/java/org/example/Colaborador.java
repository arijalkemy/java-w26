package org.example;

public class Colaborador implements ConsultaSaldo, Retiro{
    @Override
    public void transaccionOk(String transaccion) {
        System.out.println("Transaccion ok" + transaccion);
    }

    @Override
    public void transaccionNOk(String transaccion) {
        System.out.println("Transaccion NOk" + transaccion);
    }

    @Override
    public void retirar() {
        System.out.println("Retirar");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Consultar saldo");
    }
}
