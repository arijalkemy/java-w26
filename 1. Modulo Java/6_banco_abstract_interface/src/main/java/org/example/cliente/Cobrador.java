package org.example.cliente;

import org.example.transaccion.ConsultaSaldo;
import org.example.transaccion.RetirarEfectivo;

public class Cobrador extends Cliente implements RetirarEfectivo, ConsultaSaldo {

    public Cobrador(String nombre, String dni) {
        super(nombre, dni);
    }

    @Override
    public void retirarEfectivo(double dinero) {
        System.out.println("Retirando $ " + dinero);
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion desde COBRADOR OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion desde COBRADOR NO OK");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo del COBRADOR...");
    }
}
