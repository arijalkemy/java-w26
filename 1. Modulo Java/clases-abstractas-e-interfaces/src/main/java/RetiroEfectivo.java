public class RetiroEfectivo implements ITransaccion{
    public void transaccionOk() {
        System.out.println("Retirando efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo retirar efectivo");
    }
}
