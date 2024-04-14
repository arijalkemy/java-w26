package org.example;

import java.util.List;

public class Factura {
    Cliente cliente;
    List<Item> productos;
    Double valorTotal;

    public Factura(Cliente cliente, List<Item> productos, Double valorTotal) {
        this.cliente = cliente;
        this.productos = productos;
        this.valorTotal = valorTotal;
    }
}
