package org.example;

public class UserCobrador implements IRetiro, IConsultaDeSaldo{
    @Override
    public void realizarConsultaSaldo() {
        System.out.println("Consulta de saldos");
    }

    @Override
    public void realizarRetiro() {
        System.out.println("Realizar retiro");
    }
}
