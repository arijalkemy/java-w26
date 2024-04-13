package org.example;

import java.util.List;

public class Factura {

    // Las facturas que se generan cuando un cliente hace una compra contienen a un cliente, una lista de ítems y el total de la compra.

    private Cliente cliente;
    private List<Item> listaItems;
    private double precioTotal;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.listaItems = items;
        this.precioTotal = calcularTotal();
    }

    public double calcularTotal() {
        return listaItems.stream().mapToDouble(i -> i.getPrecioUnidad() * i.getCantComprada()).sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Factura: " +
                "cliente=" + cliente +
                ", items=" + listaItems +
                ", precioTotal=" + precioTotal;
    }
}
