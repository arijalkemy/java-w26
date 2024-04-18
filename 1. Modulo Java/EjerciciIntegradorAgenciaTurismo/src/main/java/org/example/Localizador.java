package org.example;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private int identificador;
    private double total;
    private List<String> tipo;

    public Localizador(Cliente cliente, int identificador, double total, List<String> tipo) {
        this.cliente = cliente;
        this.identificador = identificador;
        this.total = total;
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public List<String> getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "Nombre:"+ cliente.getNombre() +
                ", Apellido:"+ cliente.getApellido() +
                ", identificador=" + identificador +
                ", total=" + total +
                ", tipo=" + tipo +
                '}';
    }
}


