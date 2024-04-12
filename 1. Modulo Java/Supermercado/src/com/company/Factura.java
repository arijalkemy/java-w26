package com.company;

import java.util.Arrays;

public class Factura {
    private Cliente cliente;
    private Item[] items;
    private double total;

    public Factura(Cliente cliente, Item[] items) {
        this.cliente = cliente;
        this.items = items;
        this.total = Arrays.stream(items).mapToDouble(Item::getCostoUnitario).sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Item[] getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }
}
