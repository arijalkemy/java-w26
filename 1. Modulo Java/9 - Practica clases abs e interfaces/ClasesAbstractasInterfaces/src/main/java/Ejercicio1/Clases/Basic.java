package org.example.Clases;

import org.example.Interfaces.ConsultaSaldo;
import org.example.Interfaces.PagosDeServicios;
import org.example.Interfaces.RetiroDeEfectivo;

public class Basic implements ConsultaSaldo, PagosDeServicios, RetiroDeEfectivo {
    @Override
    public void consultarSaldo() {
        System.out.println("Su saldo es de 1$, desde Basic");
    }

    @Override
    public void pagarServicios() {
        System.out.println("Se pago el servicio correctamente, desde Basic");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Se retiro 1$, desde Basic");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion Ok, desde Basic");
    }
    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion NoOk, desde Basic");
    }
}
