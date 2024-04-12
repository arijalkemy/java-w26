package org.example;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    // El total de la compra se podria deducir de la suma del total de los items.
    // Pero como este valor no va a cambiar una vez emitida la factura, prefiero persistir este valor en el objeto Factura y no volver a calcularlo.
    private double total;

    public Factura(Cliente cliente, List<Item> items, double total) {
        this.cliente = cliente;
        this.items = items;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
