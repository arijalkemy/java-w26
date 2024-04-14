package org.example;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Producto> listDeItems;
    private Double totalDeLaCompra;

    public Factura(Cliente cliente, List<Producto> listDeItems, Double totalDeLaCompra) {
        this.cliente = cliente;
        this.listDeItems = listDeItems;
        this.totalDeLaCompra = totalDeLaCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getListDeItems() {
        return listDeItems;
    }

    public void setListDeItems(List<Producto> listDeItems) {
        this.listDeItems = listDeItems;
    }

    public Double getTotalDeLaCompra() {
        return totalDeLaCompra;
    }

    public void setTotalDeLaCompra(Double totalDeLaCompra) {
        this.totalDeLaCompra = totalDeLaCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listDeItems=" + listDeItems +
                ", totalDeLaCompra=" + totalDeLaCompra +
                '}';
    }
}
