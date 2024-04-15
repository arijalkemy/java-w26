package org.example.classes;

import java.util.List;

public class Factura {
    private int id;
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(int id, Cliente cliente, List<Item> items) {
        this.id = id;
        this.cliente = cliente;
        this.items = items;
        this.total = calcularTotal();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    private double calcularTotal() {
        return items.stream()
                .mapToDouble(item -> item.getPrecio() * item.getCantidadComprada())
                .sum();
    }

    @Override
    public String toString() {
        return "\n - id: " + id +
                "\n - cliente: " + cliente +
                "\n - items: " + items +
                "\n - total: " + total;
    }
}
