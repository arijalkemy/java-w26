public class RetiroDeEfectivo implements Transaccion{
    @Override
    public void TransaccionOK() {
        System.out.println("Retiro de efectivo con exito");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Retiro de efectivo sin exito");
    }
}
