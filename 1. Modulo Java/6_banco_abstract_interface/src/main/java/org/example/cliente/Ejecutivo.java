package org.example.cliente;

import org.example.transaccion.Deposito;
import org.example.transaccion.Transferencia;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {

    public Ejecutivo(String nombre, String dni) {
        super(nombre, dni);
    }

    @Override
    public void realizarDeposito(double dinero) {
        System.out.println("Depositando $ " + dinero + "...");
    }

    @Override
    public void transferir(double dinero) {
        System.out.println("Transferir: $ " + dinero);
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion OK desde EJECUTIVO");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion NO OK desde EJECUTIVO");
    }
}
