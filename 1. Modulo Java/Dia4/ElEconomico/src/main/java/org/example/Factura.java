package org.example;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private double totalCompra;
    private List<Item> listaItems = new ArrayList<>();

    public Factura(Cliente cliente, double totalFactura, List<Item> itemsFactura) {
        this.cliente = cliente;
        this.totalCompra = totalFactura;
        this.listaItems = itemsFactura;

    }

    public Factura(Cliente cliente, int totalCompra, List<Item> listaItems) {
        this.cliente = cliente;
        this.totalCompra = totalCompra;
        this.listaItems = listaItems;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", totalCompra=" + totalCompra +
                ", listaItems=" + listaItems +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(int totalCompra) {
        this.totalCompra = totalCompra;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }
}
