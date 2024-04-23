package org.example.repository;

import org.example.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements repositoryCRUD<Cliente> {
    List<Cliente> clienteList = new ArrayList<>();
    @Override
    public void save(Cliente objeto) {
        clienteList.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Cliente c : clienteList){
            System.out.println("------ Cliente ------");
            System.out.println("Dni: "+c.getDni());
            System.out.println("Nombre: "+c.getNombre());
            System.out.println("Apellido: "+c.getApellido());
        }
    }

    @Override
    public Optional<Cliente> buscar(long id) {
        for (Cliente c : clienteList){
            if (c.getDni().equals(id)){
                System.out.println("------ Cliente encontrado!!! ------");
                System.out.println("Dni: "+c.getDni());
                System.out.println("Nombre: "+c.getNombre());
                System.out.println("Apellido: "+c.getApellido());
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(long id) {
        Optional<Cliente> cl1 = this.buscar(id);
        if (cl1.isEmpty()) {
            System.out.println("Se ha eliminado el cliente exitosamente!!!");
            clienteList.remove(cl1.get());
        } else {
            System.out.println("No se encontro el cliente a eliminar");
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return clienteList;
    }
}
