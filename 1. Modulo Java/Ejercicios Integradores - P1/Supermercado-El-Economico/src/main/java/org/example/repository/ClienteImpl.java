package org.example.repository;

import org.example.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImpl implements ICRUDRepository<Cliente> {

    List<Cliente> listaClientes = new ArrayList<>();

    @Override
    public void guardar(Cliente objeto) {
        listaClientes.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    @Override
    public Optional<Cliente> buscar(Long dniBuscado) {
        Optional<Cliente> clienteEncontrado = listaClientes.stream().
                filter((cliente) -> dniBuscado == cliente.getDni())
                .findFirst();
        clienteEncontrado.ifPresent(System.out::println);
        return clienteEncontrado;
    }

    @Override
    public void eliminar(Long dniBuscado) {
        Optional<Cliente> cliente = buscar(dniBuscado);
        if (cliente.isEmpty()) {
            System.out.println("El cliente no existe en nuestra base de datos");
        } else {
            listaClientes.remove(cliente.get());
            System.out.println("Cliente borrado exitosamente");
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return listaClientes;
    }
}
