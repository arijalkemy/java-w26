package org.example.repositorios.impl;

import org.example.entidades.Cliente;
import org.example.repositorios.IRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class IRepositorioImplCliente implements IRepositorio<Cliente> {
    private List<Cliente> clienteList = new ArrayList<>();
    @Override
    public void agregar(Cliente elem) {
        clienteList.add(elem);
    }

    @Override
    public Optional<Cliente> encontrar(Integer id) {
        return this.clienteList.stream()
                .filter(e-> e.getId().equals(id))
                .findFirst();
    }


    @Override
    public List<Cliente> encontrarTodos() {
        return this.clienteList;
    }
}
