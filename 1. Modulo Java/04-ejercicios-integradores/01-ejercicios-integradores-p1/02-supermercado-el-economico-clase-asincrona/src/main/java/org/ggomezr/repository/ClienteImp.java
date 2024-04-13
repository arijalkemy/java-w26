package org.ggomezr.repository;

import org.ggomezr.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ClienteImp implements CRUDRepository<Cliente> {

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void save(Cliente objeto) {
        clientes.add(objeto);
    }

    @Override
    public void mostrarPorPantalla() {
        for (Cliente cliente: clientes){
            System.out.println("-----------------------------");
            System.out.println("DNI: " + cliente.getDni());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: " + cliente.getApellido());
            System.out.println("-----------------------------");
        }
    }

    @Override
    public void buscar(Long dniCliente) {
        Optional<Cliente> clienteEncontrado = clientes.stream().filter(cliente -> Objects.equals(cliente.getDni(), dniCliente)).findFirst();

        if(clienteEncontrado.isPresent()) {
            mostrarObjeto(clienteEncontrado);
        }else{
            System.out.println("Cliente no encontrado");
        }
    }

    @Override
    public void eliminar(Long dniClienteAEliminar) {
        boolean removed = clientes.removeIf(cliente -> Objects.equals(cliente.getDni(), dniClienteAEliminar));
        if(removed){
            System.out.println("Cliente eliminado correctamente");
        }else{
            System.out.println("Cliente no encontrado");
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return clientes;
    }

    @Override
    public void mostrarObjeto(Optional<Cliente> cliente) {
        System.out.println("-----------------------------");
        System.out.println("DNI: " + cliente.get().getDni());
        System.out.println("Nombre: " + cliente.get().getNombre());
        System.out.println("Apellido: " + cliente.get().getApellido());
        System.out.println("-----------------------------");
    }
}
