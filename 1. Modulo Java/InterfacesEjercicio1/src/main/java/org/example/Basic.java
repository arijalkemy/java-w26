package org.example;

public class Basic implements IConsulta, IServicios, IRetiro{
    public Basic() {
    }

    @Override
    public void transaccionOkC() {
        System.out.println("Transaccion ok Consulta");
    }

    @Override
    public void transaccionNoOkC() {
        System.out.println("Transaccion no Ok Consulta");
    }

    @Override
    public void transaccionOkR() {
        System.out.println("Transaccion ok Retiro");
    }

    @Override
    public void transaccionNoOkR() {
        System.out.println("Transaccion no Ok Retiro");
    }

    @Override
    public void transaccionOkS() {
        System.out.println("Transaccion ok Servicio");
    }

    @Override
    public void transaccionNoOkS() {
        System.out.println("Transaccion no Ok Servicio");
    }
}
