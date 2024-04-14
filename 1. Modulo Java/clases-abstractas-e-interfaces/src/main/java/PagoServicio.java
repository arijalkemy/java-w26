public class PagoServicio implements ITransaccion{
    public void transaccionOk() {
        System.out.println("Pagando servicio");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo pagar servicio");
    }
}
