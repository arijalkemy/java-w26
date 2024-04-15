package org.example.repositorio.impl;

import org.example.entidad.Cliente;
import org.example.repositorio.IRepositorioCRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class IRepositorioCRUDImplCliente implements IRepositorioCRUD<Cliente> {
    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void guardar(Cliente element) {
        clientes.add(element);
    }

    @Override
    public Optional<Cliente> encontrar(Long id) {
        Optional<Cliente> cliente = clientes.stream()
                .filter(e -> e.getDni().equals(id))
                .findFirst();

        return cliente;
    }

    @Override
    public List<Cliente> encontrarTodos() {
        return clientes;
    }

    @Override
    public void borrar(Long id) {
        Optional<Cliente> cliente = encontrar(id);

        if(cliente.isPresent()){
            clientes.remove(cliente.get());
            System.out.println("CLIENTE BORRADO");
        }
        else{
            System.out.println("CLIENTE NO ENCONTRADO");
        }
    }

    @Override
    public void imprimir() {
        System.out.println("----------CLIENTES----------");
        this.clientes.forEach(System.out::println);
    }
}
