package org.example.model;

import java.util.List;

public class Factura {
    private Long codigo;
    private Cliente cli;
    private List<Item> ListaItems;
    private double total;

    public Factura() {
    }

    public Factura(Long codigo, Cliente cli, List<Item> listaItems, double total) {
        this.codigo = codigo;
        this.cli = cli;
        ListaItems = listaItems;
        this.total = total;
    }

    public Long getCodigo() {
        return codigo;
    }

    public Cliente getCli() {
        return cli;
    }

    public List<Item> getListaItems() {
        return ListaItems;
    }

    public double getTotal() {
        return total;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public void setListaItems(List<Item> listaItems) {
        ListaItems = listaItems;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
