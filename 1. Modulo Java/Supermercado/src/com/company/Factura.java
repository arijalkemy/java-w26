package com.company;

import java.util.Arrays;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.total = items.stream().mapToDouble(Item::getCostoUnitario).sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }
}
