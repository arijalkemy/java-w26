package org.example.Clases;

import java.util.List;

public class Factura {

    private int id;
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Factura() {
    }

    public Factura(int id, Cliente cliente, List<Item> items) {
        this.id = id;
        this.cliente = cliente;
        this.items = items;
        calcularTotal();
    }

    public void calcularTotal(){
        this.total = items.stream()
                .mapToDouble(Item::getCostoTotal)
                .sum();
    }


    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", \n cliente => " + cliente +
                ", \n " + items +
                ", \n total=" + total +
                '}';
    }
}
