package org.example;

import java.util.ArrayList;
import java.util.List;

public class ClientService implements CRUD<Cliente> {
    private List<Cliente> clientes;

    public ClientService() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void create(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente read(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void update(Cliente clienteActualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni().equals(clienteActualizado.getDni())) {
                clientes.set(i, clienteActualizado);
                break;
            }
        }
    }

    @Override
    public void delete(String dni) {
        clientes.removeIf(cliente -> cliente.getDni().equals(dni));
    }

    @Override
    public List<Cliente> getAll() {
        return clientes;
    }

}