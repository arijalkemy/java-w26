package org.example.classes;

import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> items;
    private double monto;

    private int numeroFactura;
    private static int numeroFacturasCounter;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.monto = items.stream()
                .mapToDouble(Item::costoItem)
                .sum();
        this.numeroFactura = numeroFacturasCounter++;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "\nnumeroFactura= " + numeroFactura +
                "\nmonto= $" + monto +
                "\ncliente= " + cliente +
                "\nitems= " + items +
                "\n}";
    }
}
