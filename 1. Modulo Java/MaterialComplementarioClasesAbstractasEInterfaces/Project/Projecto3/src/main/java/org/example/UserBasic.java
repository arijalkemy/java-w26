package org.example;

public class UserBasic implements IConsultaDeSaldo, IPagoServicios, IRetiro{

    @Override
    public void realizarConsultaSaldo() {
        System.out.println("Consulta saldo");
    }

    @Override
    public void realizarPagoServicios() {
        System.out.println("Pago servicios");
    }

    @Override
    public void realizarRetiro() {
        System.out.println("Realizar retiro");
    }
}
