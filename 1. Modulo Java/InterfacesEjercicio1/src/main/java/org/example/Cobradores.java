package org.example;

public class Cobradores implements IRetiro, IConsulta{
    public Cobradores() {
    }

    @Override
    public void transaccionOkC() {
        System.out.println("transaccion Ok Consulta");
    }

    @Override
    public void transaccionNoOkC() {
        System.out.println("transaccion No Consulta");
    }

    @Override
    public void transaccionOkR() {
        System.out.println("transaccion Ok Retiro");
    }

    @Override
    public void transaccionNoOkR() {
        System.out.println("transaccion No Retiro");
    }
}
