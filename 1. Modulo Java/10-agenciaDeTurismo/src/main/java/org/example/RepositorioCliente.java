package org.example;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {

    private List<Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new ArrayList<>();
    }

    public Cliente getCliente(String dni) {
        return clientes.stream().filter(c -> c.getDni().equals(dni)).findFirst().orElse(null);
    }

    public void addCliente(Cliente c) {
        if (getCliente(c.getDni()) != null) {
            this.clientes.add(c);
        }
    }

}
