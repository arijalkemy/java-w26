package org.example.repository;

import org.example.classes.Cliente;
import org.example.interfaces.ICRUD;

import java.util.ArrayList;
import java.util.List;

public class ClientesRepository implements ICRUD<Cliente> {

    private final List<Cliente> clientes;

    public ClientesRepository() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void create(Cliente cliente) {
        if (cliente != null) {
            this.clientes.add(cliente);
            return;
        }
        System.out.println("El cliente no puede ser null");
    }

    @Override
    public Cliente search(Number id) {
        return this.clientes.stream()
                .filter(cliente -> cliente.getDni() == id.longValue())
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Cliente cliente) {}

    @Override
    public void delete(Number id) {
        this.clientes.removeIf(cliente -> cliente.getDni() == id.longValue());
    }

    @Override
    public List<Cliente> getAll() {
        return List.of();
    }
}
