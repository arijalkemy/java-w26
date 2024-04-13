package org.example;

import java.util.List;

public class RepositorioClientes {
    public List<Cliente> clientes;

    public RepositorioClientes() {
    }

    public RepositorioClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
}