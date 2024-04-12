package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class RepositorioClientes {
    private HashMap<String, Cliente> clientes;

    public RepositorioClientes() {
      this.clientes = new HashMap<String, Cliente>();
    }

    public void guardar(Cliente cliente) {
        this.clientes.put(cliente.getDni(), cliente);
    }

    public ArrayList<Cliente> obtenerLista(Cliente cliente) {
        return (ArrayList<Cliente>) this.clientes.values();
    }

    public Cliente buscar(String dni) {
        return this.clientes.get(dni);
    }
}
