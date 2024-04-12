package bootcamp.bendezujonathan.facturacion;

import java.util.List;

import bootcamp.bendezujonathan.cliente.Cliente;

public class Factura {

    private Cliente owner;
    private List<Item> items;
    private double total;

    public Factura(Cliente owner, List<Item> items) {
        this.owner = owner;
        this.items = items;
        this.total = this.calculateTotal();
    }

    public double calculateTotal() {
        return this.items
                .stream()
                .mapToDouble(Item::calculateCosto)
                .sum();
    }

    public Cliente getOwner() {
        return owner;
    }

    public void setOwner(Cliente owner) {
        this.owner = owner;
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

}
