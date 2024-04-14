package org.example;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {
    private List<Cliente> clientes = new ArrayList<>();

    public RepositorioCliente() {
    }

    public RepositorioCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
}
