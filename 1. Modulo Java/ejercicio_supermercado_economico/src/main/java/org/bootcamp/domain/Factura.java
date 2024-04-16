package org.bootcamp.domain;

import java.util.List;

public class Factura {

    private static int contadorId = 0;
    private int idFactura;
    private List<Item> items;
    private Cliente cliente;
    private double totalCompra;

    public Factura() {
        this.idFactura = ++contadorId;
    }

    public Factura(List<Item> items, Cliente cliente, double totalCompra) {
        this.items = items;
        this.cliente = cliente;
        this.totalCompra = totalCompra;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("\n*** Factura ***");
        sb.append("\nid factura: ").append(idFactura);
        sb.append("\nitems: \n");
        items.forEach(item -> sb.append(item.toString()));
        sb.append("\ncliente: ").append(cliente.getDni());
        sb.append("\ncliente: ").append(cliente.getNombre());
        sb.append("\ntotalCompra: ").append(totalCompra);
        return sb.toString();
    }
}
