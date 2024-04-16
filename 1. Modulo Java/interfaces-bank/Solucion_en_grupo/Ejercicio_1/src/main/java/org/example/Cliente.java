package org.example;

public abstract class Cliente {
    String nombre_apellido;

    public Cliente(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public abstract void depositar();

    public abstract void transferir();

    public abstract void consultar_saldo();

    public abstract void pagar_servicio();

    public abstract void retirar_efectivo();

}
