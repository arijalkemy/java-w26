package org.example.Clases;

import org.example.Interfaces.ICrud;

import java.util.List;
import java.util.Optional;

public class AdministradorCliente implements ICrud<Cliente, Long> {

    private List<Cliente> clientes;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public AdministradorCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public Optional<Cliente> findById(Long dni) {
        return clientes.stream().
                filter(c -> c.getDni().equals(dni))
                .findFirst();
    }

    @Override
    public List<Cliente> findAll() {
        return clientes;
    }

    @Override
    public Cliente save(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public Cliente update(Cliente cliente) {
        Optional<Cliente> clienteOptional = clientes.stream()
                .filter(c -> c.getDni().equals(cliente.getDni()))
                .findFirst();

        if(clienteOptional.isEmpty())
            return null;

        clientes.remove(clienteOptional);
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public void delete(Cliente cliente) {
        clientes.remove(cliente);
    }
}
