package org.example;

import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private ArrayList<Item> items;
    private double montoTotal;

    public Factura(Cliente cliente, ArrayList<Item> items, double montoTotal) {
        this.cliente = cliente;
        this.items = items;
        this.montoTotal = montoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
}

