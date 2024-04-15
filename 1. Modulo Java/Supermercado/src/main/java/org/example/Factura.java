package org.example;

import java.util.Arrays;
import java.util.List;

public class Factura {
    double total;
    Cliente cliente;
    List<Item> items;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.total = 0;
        for (Item item : items) {
            this.total += item.getCantidad() * item.getPrecio();
        }
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
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

    @Override
    public String toString() {
        return "Factura{" +
                "total=" + total +
                ", cliente=" + cliente.getNombre() +
                ", items=" + getItemsString() +
                '}';
    }

    public String getItemsString() {
        String finalString = "";
        return items.stream().map(Item::getNombre).reduce(finalString, (acc, item) -> acc + item + ", ");
    }
}
