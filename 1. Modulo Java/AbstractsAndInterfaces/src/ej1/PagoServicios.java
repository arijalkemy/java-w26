package ej1;

public class PagoServicios implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Servicios pagados con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Usuario no tiene acceso a pago de servicios");
    }
}
