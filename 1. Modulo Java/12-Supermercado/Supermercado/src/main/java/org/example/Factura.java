package org.example;

import java.util.List;

public class Factura {
    private int numero;
    private Cliente cliente;
    private List<Producto> items;
    private double total;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getItems() {
        return items;
    }

    public void setItems(List<Producto> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Factura(int numero, Cliente cliente, List<Producto> items, double total) {
        this.numero = numero;
        this.cliente = cliente;
        this.items = items;
        this.total = total;
    }
}
