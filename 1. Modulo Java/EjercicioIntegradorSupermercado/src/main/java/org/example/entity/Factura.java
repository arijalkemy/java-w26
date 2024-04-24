package org.example.entity;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double totalCompras;
    private int codigo;

    public Factura(Cliente cliente, List<Item> items, double totalCompras, int codigo) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompras = totalCompras;
        this.codigo = codigo;
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

    public double getTotalCompras() {
        return totalCompras;
    }

    public void setTotalCompras(double totalCompras) {
        this.totalCompras = totalCompras;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente.toString() +
                ", items=" + items +
                ", totalCompras=" + totalCompras +
                ", codigo=" + codigo +
                '}';
    }
}
