package bank.transactions;

public class Transferencia implements Transaccion {
    public void transaccionOk() {
        System.out.println("Realizándose transacción");
    }

    public void transaccionNoOk() {
        System.out.println("No se realizó transacción");
    }
}
