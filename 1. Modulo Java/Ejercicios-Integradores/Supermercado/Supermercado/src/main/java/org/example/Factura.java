package org.example;

import java.util.List;

public class Factura {
    Cliente cliente;
    List<Producto> items;

    public Factura(Cliente cliente, List<Producto> items) {
        this.cliente = cliente;
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getItems() {
        return items;
    }

    public void setItems(List<Producto> items) {
        this.items = items;
    }

}

