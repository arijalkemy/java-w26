package com.example;

import java.util.List;

public class Factura {
    Cliente cliente;
    List<Producto> items;
    double costoTotal;

    public Factura(Cliente cliente, List<Producto> items) {
        this.cliente = cliente;
        this.items = items;
        this.costoTotal = items
                .stream()
                .mapToDouble(Producto::obtenerCostoPorProducto)
                .sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getItems() {
        return items;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

}
