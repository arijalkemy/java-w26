package org.example.repository;

import org.example.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUDRepository<Cliente> {
    List<Cliente> listaClientes = new ArrayList<>();
    @Override
    public void save(Cliente objeto) {
        listaClientes.add(objeto);

    }

    @Override
    public void mostrarPantalla() {
        for (Cliente cliente : listaClientes) {
            System.out.println("----------------------------");
            System.out.println(cliente.toString());
        }
    }

    @Override
    public Optional<Cliente> buscar(Long id) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getDni().equals(id)) {
                System.out.println("cliente encontrado");
                System.out.println("Dni: " + cliente.getDni());
                System.out.println("nombre: " + cliente.getNombre());
                System.out.println("apellido: " + cliente.getApellido());
                return Optional.of(cliente);
            }else {
                System.out.println("cliente no encontrado");
            }
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {
        Optional<Cliente> cliente = buscar(id);
        if (cliente.isEmpty()) {
            System.out.println("cliente no encontrado");
        }else {
            System.out.println("cliente removido");
            listaClientes.remove(cliente.get());
        }
    }

    @Override
    public List<Cliente> buscarTodos() {
        return listaClientes;
    }
}
