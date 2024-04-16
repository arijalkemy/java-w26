package bank.transactions;

public class RetiroEfectivo implements Transaccion {

    public void transaccionOk() {
        System.out.println("Retiro efectivo realizado");
    }

    public void transaccionNoOk() {
        System.out.println("Retiro efectivo no realizado");
    }
}
