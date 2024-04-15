package org.example;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private Double montoTotal;

    public Factura(Cliente cliente, List<Item> items, Double montoTotal) {
        this.cliente = cliente;
        this.items = items;
        this.montoTotal = montoTotal;
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

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
