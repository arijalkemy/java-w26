package org.example;

import java.util.ArrayList;

public class Factura {
    private String id;

    private Cliente cliente;
    private ArrayList<Item> items;
    private double total;

    public Factura(String id, Cliente cliente, ArrayList<Item> items, double total) {
        this.cliente = cliente;
        this.items = items;
        this.total = total;
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id='" + id + '\'' +
                ", cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
