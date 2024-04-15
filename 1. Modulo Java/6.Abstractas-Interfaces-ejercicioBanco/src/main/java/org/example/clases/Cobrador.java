package org.example.clases;

import org.example.interfaces.ConsultaDeSaldo;
import org.example.interfaces.RetiroDeEfectivo;

public class Cobrador implements RetiroDeEfectivo, ConsultaDeSaldo {
    @Override
    public void hacerRetiro() {
        System.out.println("Retiro en proceso...");

    }

    @Override
    public void transaccionOk() {
        System.out.println("¡Transacción realizada con exito!");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción fallida :(");

    }

    @Override
    public void hacerConsultaDeSaldo() {
        System.out.println("Se está realizando una consulta de saldo...");
    }
}
