package org.example.ejercicio3;

import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;


    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;

        this.totalCompra = items.stream().mapToDouble(Item::calcularCostoItem).sum();
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

    @Override
    public String toString() {
        return "Factura{" +
            "cliente=" + cliente +
            ", totalCompra=" + totalCompra +
            ", items=" + items +
            '}';
    }
}
