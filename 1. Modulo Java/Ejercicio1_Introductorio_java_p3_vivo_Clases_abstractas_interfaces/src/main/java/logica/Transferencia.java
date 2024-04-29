package logica;

public class Transferencia implements ITransaccion {
    @Override
    public void transaccionOK() {
        System.out.println("Realizando transferencia");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("No se puede realizar la transferencia");
    }
}
