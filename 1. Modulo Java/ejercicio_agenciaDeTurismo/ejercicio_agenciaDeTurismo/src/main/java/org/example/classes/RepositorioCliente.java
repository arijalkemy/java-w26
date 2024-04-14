package org.example.classes;

import org.example.interfaces.IRepositorio;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente implements IRepositorio<Cliente> {
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void add(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void Add(Cliente item) {
        clientes.add(item);
    }

    @Override
    public Cliente findOne(int id) {
        return (Cliente) clientes
                .stream()
                .filter(cliente -> cliente.getId() == id);
    }
}
