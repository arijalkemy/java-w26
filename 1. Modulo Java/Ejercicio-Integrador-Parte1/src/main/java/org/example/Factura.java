package org.example;

import java.util.List;

public class Factura {
    private Cliente cliente;
    List<Item> items;
    private double totalCompra;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = calcularTotalCompra();
    }

    private double calcularTotalCompra() {
        return items.stream().mapToDouble(t -> t.getCostoUnitario() * t.getCantidadComprada()).sum();
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

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
