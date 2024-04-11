package org.example.AbstractClass_Interfaces;

public class Cobrador implements ConsultaRetiro{

    @Override
    public void consulta() {
        System.out.println("Consulta realizada");
    }

    @Override
    public void retiro() {
        System.out.println("Retiro realizado");
    }
}
