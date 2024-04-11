package ej1;

public class Deposito implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Depósito correcto");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El usuario no tiene acceso a Depósitos.");
    }
}
