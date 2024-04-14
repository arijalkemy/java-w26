package org.entities.supermercado.repositorios;

import org.entities.supermercado.Cliente;
import org.entities.supermercado.interfaces.IRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteRepository implements IRepository<Cliente> {
    Map<String, Cliente> clienteMap = new HashMap();
    @Override
    public void guardar(Cliente cliente) {
        clienteMap.put(cliente.getDni(), cliente);
        System.out.println("Guardado cliente: " + cliente.getDni() +" con exito");
    }

    @Override
    public Cliente recuperar(String id) {
        return clienteMap.get(id);
    }

    @Override
    public List<Cliente> recuperarTodos() {
        return new ArrayList<>(clienteMap.values());
    }

    @Override
    public void eliminar(String id) {
        clienteMap.remove(id);
    }

}
