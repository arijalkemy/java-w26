package org.example.repository;
import org.example.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioCliente implements Repositorio<Cliente, Integer> {
    private List<Cliente> listaClientes;

    public RepositorioCliente () {
        listaClientes = new ArrayList<>();
    }

    @Override
    public void add(Cliente item) {
        listaClientes.add(item);
    }

    @Override
    public List<Cliente> findAll() {
        return listaClientes;
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return listaClientes.stream().filter(c -> c.getId() == id).findFirst();
    }

    @Override
    public Boolean existsById(Integer id) {
        return listaClientes.stream().anyMatch(c -> c.getId() == id);
    }

}
