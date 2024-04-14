package org.respositorio;

import org.entities.Cliente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class ClienteRepositorio {
    private Collection<Cliente> clientes = new HashSet<>();

    public Cliente crearCliente(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    public Cliente buscarCliente(int clienteId) {
        return clientes.stream().filter(cliente -> cliente.getId() == clienteId).findFirst().orElse(null);
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }
}
