package ej1;

public class RetiroEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Efectivo retirado con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Usuario no tiene acceso a Retiro de efectivo");
    }
}
