public class Transference implements Transaction{

    @Override
    public void transactionOk() {
        System.out.println("Transferencia Realizada");
    }

    @Override
    public void transactionNoOk() {

    }
}
