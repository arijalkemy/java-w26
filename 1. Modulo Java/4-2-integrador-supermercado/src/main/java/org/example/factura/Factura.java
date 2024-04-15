package org.example.factura;

import org.example.Cliente;
import org.example.factura.Item;

import java.util.List;

public class Factura {

    private Cliente cliente;

    private List<Item> items;

    private double total;

    public Factura(Cliente cliente, List<Item> items, double total) {
        this.cliente = cliente;
        this.items = items;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotal(){
        return items.stream()
                .mapToDouble(Item::getCosto)
                .sum();
    }
}
