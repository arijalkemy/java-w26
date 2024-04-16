package org.example.repository;

import org.example.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ClienteImpl implements CRUDRepository{

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void save(Cliente object) {
        clientes.add(object);
    }

    @Override
    public void mostrarPantalla() {
        for (Cliente cliente : clientes) {
            System.out.println("Apellido: " + cliente.getNombre());
            System.out.println("Nombre: " + cliente.getApellido());
            System.out.println("DNI: " + cliente.getDni());
        }
    }

    @Override
    public Optional buscar(Long id) {
        boolean flag = false;
        for (Cliente cliente : clientes) {
            if (Objects.equals(cliente.getDni(), id)) {
                clientes.remove(cliente);
                flag = true;
                return Optional.of(cliente);
            }
        }
        if (!flag) {
            System.out.println("DNI de persona no encontrado");
        }

        return Optional.empty();
    }

    @Override
    public void elminar(Long id) {
        Optional cliente = this.buscar(id);

        if (cliente.isEmpty()) {
            System.out.println("DNI de persona no encontrado");
        }else  {
            clientes.remove(cliente.get());
            System.out.println("DNI de persona borrado correctamente");
        }

    }
}
