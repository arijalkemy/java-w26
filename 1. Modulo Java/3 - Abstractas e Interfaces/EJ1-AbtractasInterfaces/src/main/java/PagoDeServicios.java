public class PagoDeServicios implements Transaccion{
    @Override
    public void TransaccionOK() {
        System.out.println("Pago de servicio con exito");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Pago de servicio sin exito");
    }
}
