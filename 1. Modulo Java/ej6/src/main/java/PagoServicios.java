public class PagoServicios implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicios no realizado");
    }
}
