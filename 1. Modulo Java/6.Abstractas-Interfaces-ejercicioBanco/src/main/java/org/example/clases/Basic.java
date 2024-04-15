package org.example.clases;

import org.example.interfaces.ConsultaDeSaldo;
import org.example.interfaces.PagoDeServicios;
import org.example.interfaces.RetiroDeEfectivo;

public class Basic implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo {
    @Override
    public void hacerPagoDeServicio() {
        System.out.println("Se está realizando el Paga de un servicio...");

    }

    @Override
    public void hacerRetiro() {
        System.out.println("Se está realizando un retiro...");

    }

    @Override
    public void transaccionOk() {
        System.out .println("¡Transacción realizada con exito!");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción fallida :(");

    }

    @Override
    public void hacerConsultaDeSaldo() {
        System.out.println("Realizando consulta de saldo");

    }
}
