package punto1;

public class PagoServicios implements Transaccion{
    public void realizarPago(){
        System.out.println("Realizando pago de servicios");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicios no realizado");
    }
}
