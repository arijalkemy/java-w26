package org.example.repositories;

import org.example.models.Cliente;

import java.util.List;

public class ClienteRepository implements ICRUD<Cliente, Integer> {
    @Override
    public Cliente create(Cliente cliente) {
        Cliente newCliente = baseDeDatos.clienteById(cliente.getDni());
        if (newCliente == null) {
            baseDeDatos.agregarCliente(cliente);
            System.out.println("Cliente Nuevo");
            return cliente;
        }
        System.out.println("Cliente Existente");
        return newCliente;
    }

    @Override
    public List<Cliente> read() {
        return baseDeDatos.getClientes();
    }

    @Override
    public Cliente update(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente delete(Cliente cliente) {
        return baseDeDatos.eliminarCliente(cliente.getDni());
    }

    @Override
    public Cliente getByID(Integer dni) {
        return baseDeDatos.clienteById(dni);
    }
}
