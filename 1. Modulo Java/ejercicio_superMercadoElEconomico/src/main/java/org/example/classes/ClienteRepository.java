package org.example.classes;

import org.example.interfaces.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository implements IRepository<Cliente> {

    private List<Cliente> clienteList;

    public ClienteRepository() {
        this.clienteList = new ArrayList<Cliente>();
    }

    @Override
    public void add(Cliente object) {
        try {
            clienteList.add(object);
        } catch(Exception ex) {
            System.out.println("Ocurrió un error al añadir la Factura al listado.");
        }
    }

    @Override
    public Cliente get(int id) {
        Optional<Cliente> resultado = clienteList
                .stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst();

        if (resultado.isPresent()) return resultado.get();
        return null;
    }

    @Override
    public List<Cliente> getAll() {
        return clienteList;
    }

    @Override
    public void put(int id, Cliente object) {
        clienteList.forEach(cliente -> {
            if (cliente.getId() == id) {
                int indice = clienteList.indexOf(cliente);
                clienteList.set(indice, object);
                System.out.println("Cliente modificado exitosamente.");
                return;
            };
        });

        System.out.println("No se encontró el Cliente con el id: " + id);
    }

    @Override
    public void delete(int id) {
        Optional<Cliente> resultado = clienteList
                .stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst();

        if (resultado.isPresent()) {
            clienteList.remove(resultado.get());
            System.out.println("Cliente eliminado exitosamente");
        } else {
            System.out.println("No se encontró el Cliente a con el id: " + id);
        }
    }
}
