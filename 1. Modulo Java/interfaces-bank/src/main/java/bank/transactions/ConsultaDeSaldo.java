package bank.transactions;

public class ConsultaDeSaldo implements Transaccion {
    public void transaccionOk() {
        System.out.println("Consuta de saldo realizada");
    }

    public void transaccionNoOk() {
        System.out.println("Consulta de saldo no realizada");
    }
}
