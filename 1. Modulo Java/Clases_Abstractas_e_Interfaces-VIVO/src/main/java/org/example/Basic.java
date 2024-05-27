package org.example;

public class Basic implements Transaccion{
    @Override
    public boolean transaccionOk() {
        return false;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }

    // Método específico para consultar saldo
    public void consultarSaldo() {
        System.out.println("Consultando saldo para el cliente Basic.");
    }

    // Método específico para pagar servicios
    public void pagarServicios() {
        System.out.println("Pagando servicios para el cliente Basic.");
    }

    // Método específico para retirar efectivo
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo para el cliente Basic.");
    }
}
