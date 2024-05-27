package org.example;

public class Ejecutivo implements Transaccion{
    @Override
    public boolean transaccionOk() {
        System.out.println("Transacción exitosa para el Ejecutivo.");
        return true;
    }
    @Override
    public boolean transaccionNoOk() {
        System.out.println("Transacción fallida para el Ejecutivo.");
        return false;
    }

    // Método específico para ejecutar un depósito
    public void deposito() {
        transaccionOk();
        System.out.println("Realizando depósito para el Ejecutivo.");
    }

    // Método específico para ejecutar una transferencia
    public void transferencia() {
        transaccionOk();
        System.out.println("Realizando transferencia para el Ejecutivo.");
    }
}
