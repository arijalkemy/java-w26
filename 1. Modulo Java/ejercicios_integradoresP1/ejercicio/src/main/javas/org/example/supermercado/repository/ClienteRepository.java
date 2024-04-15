package org.example.supermercado.repository;

import org.example.supermercado.models.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository implements CRUD<Cliente> {

    List<Cliente> clientes;

    public ClienteRepository() {
        clientes= new ArrayList<Cliente>();
    }

    @Override
    public void create(Cliente cliente) {
        for (Cliente client: this.clientes){
            if(client.getDni().equals(client.getDni())){
                return;
            }
        }
        this.clientes.add(cliente);
    }

    @Override
    public void readAll() {
        System.out.println("Listado de Clientes: \n");
        for (Cliente cliente: this.clientes){
            System.out.println(cliente.toString());
        }
    }

    @Override
    public Optional<Cliente> busqueda() {
        return Optional.empty();
    }

    @Override
    public void eliminar() {

    }

    @Override
    public List<Cliente> obtenerTodos() {
        return this.clientes;
    }
}
