package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository {
    List<Cliente> clientes = new ArrayList<>();

    private void save(Cliente cliente) {
        clientes.add(cliente);
    }

    public Optional<Cliente> findByDni(String dni) {
        return clientes.stream()
                .filter(c -> c.getDni().equals(dni))
                .findFirst();
    }

    public void delete(Cliente cliente) {
        clientes.remove(cliente);
    }

    public List<Cliente> getAll() {
        return clientes;
    }
}
