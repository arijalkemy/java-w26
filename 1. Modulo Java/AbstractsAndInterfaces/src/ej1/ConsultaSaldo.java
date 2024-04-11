package ej1;

public class ConsultaSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Saldo consultado con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Usuario no tiene acceso a consulta de saldo");
    }
}
