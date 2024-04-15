package org.example.ejercicio_integrador_parte_1_y_2;

import java.util.List;

public class Factura {
    private Client cliente;
    private List<Item> items;
    private double total;

    public Factura(Client cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        double suma = 0;
        for(Item item : items) {
            suma = suma + item.getCostoUnitario() * item.getCantidadComprada();
        }
        this.total = suma;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
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
}
