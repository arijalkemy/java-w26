package org.example.viajes;

import java.util.HashMap;
import java.util.Map;

public class RepositorioClientes {
    private Map<String, Cliente> clientes;

    public RepositorioClientes() {
        this.clientes = new HashMap<>();
    }

    public Cliente buscarCliente(String id) {
        return clientes.get(id);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }
}
