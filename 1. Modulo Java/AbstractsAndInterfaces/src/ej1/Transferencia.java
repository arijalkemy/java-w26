package ej1;

public class Transferencia implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("ej1.Transferencia realizada con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El usuario no tiene acceso a las transferencias.");
    }
}
