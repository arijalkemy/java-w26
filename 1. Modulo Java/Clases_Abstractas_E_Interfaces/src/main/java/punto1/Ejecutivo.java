package punto1;

public class Ejecutivo {
    Deposito deposito = new Deposito();
    Transferencia transferencia = new Transferencia();

    public void realizarDeposito(){
        deposito.realizarDeposito();
        deposito.transaccionOk();
    }
    public void realizarTransferencia(){
        transferencia.realizarTransferencia();
        transferencia.realizarTransferencia();
    }
}
