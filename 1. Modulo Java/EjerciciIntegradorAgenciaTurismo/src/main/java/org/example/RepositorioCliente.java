package org.example;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {
    private List<Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public boolean existeCliente(Cliente nuevoCliente) {
        return clientes.contains(nuevoCliente);
    }
}
