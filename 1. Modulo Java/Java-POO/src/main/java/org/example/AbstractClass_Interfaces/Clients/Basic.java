package org.example.AbstractClass_Interfaces.Clients;

import org.example.AbstractClass_Interfaces.Services.ConsultaRetiro;
import org.example.AbstractClass_Interfaces.Services.Pago;

public class Basic implements ConsultaRetiro, Pago {

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
