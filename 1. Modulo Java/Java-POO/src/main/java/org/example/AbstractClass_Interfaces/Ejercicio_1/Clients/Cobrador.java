package org.example.AbstractClass_Interfaces.Ejercicio_1.Clients;

import org.example.AbstractClass_Interfaces.Ejercicio_1.Services.ConsultaRetiro;

public class Cobrador implements ConsultaRetiro {

    @Override
    public void consulta() {
        System.out.println("Consulta realizada");
    }

    @Override
    public void retiro() {
        System.out.println("Retiro realizado");
    }
}
