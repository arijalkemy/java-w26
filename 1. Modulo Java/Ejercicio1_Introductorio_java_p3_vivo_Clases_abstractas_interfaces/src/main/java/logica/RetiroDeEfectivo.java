package logica;

public class RetiroDeEfectivo implements ITransaccion {
    @Override
    public void transaccionOK() {
        System.out.println("Realizando retiro de efectivo");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("No se puede realizar el retiro de efectivo");
    }
}
