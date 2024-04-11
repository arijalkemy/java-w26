package org.example.AbstractClass_Interfaces;

public class Basic implements  ConsultaRetiro, Pago{

    @Override
    public void consulta() {
        System.out.println("Consulta realizada");

    }

    @Override
    public void retiro() {
          System.out.println("Retiro realizado");
    }

    @Override
    public void pago() {
          System.out.println("Pago realizado");
    }
}
