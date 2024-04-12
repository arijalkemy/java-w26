package org.example.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {

    private final List<Cliente> clientes;
    private final List<Factura> facturas;


    public Supermercado(List<Cliente> clientes) {
        this.clientes = clientes;
        this.facturas = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public Factura agregarFactura(Cliente cliente, List<Item> items) {

        // Si el Cliente no está registrado en el Supermercado, se lo agrega
        if (this.clientes.stream().noneMatch(c -> c.getDni().equals(cliente.getDni()))) {
            this.clientes.add(cliente);
        }

        Factura nuevaFactura = new Factura(cliente, items);
        this.facturas.add(nuevaFactura);

        return nuevaFactura;
    }
}
