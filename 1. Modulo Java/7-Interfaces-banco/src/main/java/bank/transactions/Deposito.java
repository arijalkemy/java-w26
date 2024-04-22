package bank.transactions;

public class Deposito implements Transaccion{
    public void transaccionOk() {
        System.out.println("Realizándose depósito");
    }

    public void transaccionNoOk() {
        System.out.println("Depósito no realizado");
    }
}
