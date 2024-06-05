package org.decodificador.modelo;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> listaItemsCompra;
    private Double valorTotal;

    public Factura(Cliente cliente, List<Item> listaItemsCompra, Double valorTotal) {
        this.cliente = cliente;
        this.listaItemsCompra = listaItemsCompra;
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItemsCompra() {
        return listaItemsCompra;
    }

    public void setListaItemsCompra(List<Item> listaItemsCompra) {
        this.listaItemsCompra = listaItemsCompra;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaItemsCompra=" + listaItemsCompra +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
