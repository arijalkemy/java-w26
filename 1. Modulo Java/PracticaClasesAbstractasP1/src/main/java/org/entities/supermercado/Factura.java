package org.entities.supermercado;

import org.entities.supermercado.interfaces.IRepository;
import org.entities.supermercado.repositorios.ClienteRepository;

import java.util.*;

public class Factura {
    private UUID id;
    private double total = 0;
    private Cliente cliente;
    private List<Item> items;

    public Factura(double total, Cliente cliente) {
        this.id = UUID.randomUUID();
        this.total = total;
        this.cliente = cliente;
        this.items = new ArrayList<>();
    }

    public void agregarItem(Item... itemsAgregar) {
        if(itemsAgregar.length>0) {
            Collections.addAll(this.items,itemsAgregar);
            this.total = this.items.stream().mapToDouble(Item::getPrecio).sum();
        }
    }

    public UUID getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
}
