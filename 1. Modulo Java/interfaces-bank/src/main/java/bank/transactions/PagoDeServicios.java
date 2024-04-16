package bank.transactions;

public class PagoDeServicios implements Transaccion {
    public void transaccionOk() {
        System.out.println("Pago de servicios realizado");
    }

    public void transaccionNoOk() {
        System.out.println("Pago de servicios no realizado");
    }
}
