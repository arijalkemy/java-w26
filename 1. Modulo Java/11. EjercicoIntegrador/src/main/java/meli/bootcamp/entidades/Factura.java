package meli.bootcamp.entidades;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double costoTotal;

    public Factura(Cliente clientes) {
        this.cliente = clientes;
        items = new ArrayList<>();
        costoTotal = 0.0;
    }

    public void agregarItem( Item nuevoItem){
        items.add( nuevoItem );
        costoTotal += nuevoItem.getPrecio();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente clientes) {
        this.cliente = clientes;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente.toString() +
                ", items=" + items +
                ", costoTotal=" + costoTotal +
                '}';
    }
}