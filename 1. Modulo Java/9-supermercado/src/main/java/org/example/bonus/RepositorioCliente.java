package org.example.bonus;

import org.example.Cliente;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RepositorioCliente implements ICrud<Cliente> {

    private Set<Cliente> listaClientes;

    public RepositorioCliente() {
        this.listaClientes = new HashSet<>();
    }

    @Override
    public void alta(Cliente cliente) {
        if (listaClientes.stream().filter(f -> f.getDni().equalsIgnoreCase(cliente.getDni())).count() > 0) {
            System.out.println("Ya existe un cliente con el DNI: " + cliente.getDni());
        } else {
            this.listaClientes.add(cliente);
            System.out.println("Se agrego el cliente: " + cliente);
        }
    }

    @Override
    public void baja(String dni) {
        boolean eliminarOK = listaClientes.removeIf(c -> c.getDni().equals(dni) ? true : false);
        if (eliminarOK) {
            System.out.println("El cliente con el DNI: " + dni + " fue eliminado de la lista");
        } else {
            System.out.println("No existe un cliente con ese DNI en la lista actual");
        }
    }

    @Override
    public Cliente buscar(String dni) {
        return listaClientes.stream()
                .filter(c -> c.getDni().equals(dni)).findAny().orElse(null);
    }

    @Override
    public void mostrarLista() {
        listaClientes.forEach(System.out::println);
    }

    @Override
    public List<Cliente> traerTodos() {
        return listaClientes.stream().collect(Collectors.toList());
    }
}
