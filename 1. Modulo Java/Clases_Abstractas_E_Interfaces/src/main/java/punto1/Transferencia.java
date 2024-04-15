package punto1;

public class Transferencia implements Transaccion{
    public void realizarTransferencia(){
        System.out.println("Realizandose la transferencia");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia no ha sido realizado");
    }
}
