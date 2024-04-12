package org.example.clientes;

import org.example.tiposDeTransacciones.ConsultaSaldo;
import org.example.tiposDeTransacciones.PagoServicio;
import org.example.tiposDeTransacciones.RetiroDinero;

public class Basic implements ConsultaSaldo, PagoServicio, RetiroDinero {
    @Override
    public void consultarSado() {
        System.out.println("Su saldo es: 9999999999 pesos");
    }

    @Override
    public void pagarServicio(int cantidad, String entidadAPagar) {
        System.out.println("Servicio pagado con éxito");
    }

    @Override
    public void retirarDinero(int cantidad) {
        System.out.println("Dinero retirado con éxito");
    }
}
