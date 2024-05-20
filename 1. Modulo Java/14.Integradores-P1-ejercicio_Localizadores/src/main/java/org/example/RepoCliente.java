package org.example;

import java.util.ArrayList;
import java.util.List;

public class RepoCliente {
    List<Cliente> clientes;

    public RepoCliente() {
        clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public boolean existeCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.equals(cliente)) {
                return true;
            }
        }
        return false;
    }

    public List<Localizador> encontrarReservasCliente(List<Localizador> localizadores, int dniCliente) {
        return localizadores.stream().filter(localizador -> localizador.getCliente().getDni().equals(dniCliente)).toList();
    }
}
