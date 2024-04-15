public class RetiroDeEfectivo implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro no realizado");
    }
}
