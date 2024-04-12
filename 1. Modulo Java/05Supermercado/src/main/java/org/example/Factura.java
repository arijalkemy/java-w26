package org.example;

import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private ArrayList<Item> items;
    private double montoTotal;
    private RepositorioClientes repositorio;

    public Factura(Cliente cliente, ArrayList<Item> items, RepositorioClientes repositorio) {
        this.items = items;
        this.montoTotal = items.stream()
                .map(i -> i.getCostoUnitario() * i.getCantidadComprada())
                .reduce(0.0, Double::sum);
        this.repositorio = repositorio;
        if (repositorio.buscar(cliente.getDni()) == null) {
            repositorio.guardar(cliente);
        }
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public RepositorioClientes getRepositorio() {
        return repositorio;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setRepositorio(RepositorioClientes repositorio) {
        this.repositorio = repositorio;
    }
}

