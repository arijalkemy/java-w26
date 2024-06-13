package org.example.supermercadoEconomico;
import java.util.ArrayList;
import java.util.List;

class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarItem(Item item) {
        items.add(item);
        total += item.getCantidad() * item.getCostoUnitario();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
