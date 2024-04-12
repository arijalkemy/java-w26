package org.example;
import java.util.*;


import java.util.*;

public class RepositorioClienteImpl implements RepositorioCliente {
    private Map<Integer, Cliente> clientes = new HashMap<>();

    @Override
    public void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    @Override
    public Optional<Cliente> buscarCliente(int id) {
        return Optional.ofNullable(clientes.get(id));
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return new ArrayList<>(clientes.values());
    }

    @Override
    public List<Localizador> obtenerLocalizadoresDelCliente(int clienteId) {
        Cliente cliente = clientes.get(clienteId);
        if (cliente != null) {
            return cliente.getLocalizadores();
        }
        return new ArrayList<>();
    }
}
