package org.example.models;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Factura {
    private Set<Item> items = new HashSet<Item>();
    private Cliente cliente;
    private Long codigo;

    public Factura(Long codigo, Set<Item> items, Cliente cliente) {
        this.codigo = codigo;
        this.items = items;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "items=" + items +
                ",\n cliente=" + cliente +
                ",\n codigo=" + codigo +
                '}';
    }

    public Long getCodigo() {
        return codigo;
    }

    public double getPrecioTotalFactura(){
        return items.stream().mapToDouble(Item::getPrecioTotalItem).sum();
    }

    public Cliente getCliente() {
        return cliente;
    }
}
