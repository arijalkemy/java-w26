package org.example.clientes;

import org.example.tiposDeTransacciones.IConsultaSaldo;
import org.example.tiposDeTransacciones.IPagoServicio;
import org.example.tiposDeTransacciones.IRetiroDinero;

public class Basic implements IConsultaSaldo, IPagoServicio, IRetiroDinero {
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
