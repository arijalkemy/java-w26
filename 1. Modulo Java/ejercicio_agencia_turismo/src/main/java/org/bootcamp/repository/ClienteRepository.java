package org.bootcamp.repository;

import org.bootcamp.domain.Cliente;

import java.util.*;

public class ClienteRepository implements IGeneric<Cliente> {

    private static Set<Cliente> clientes;
    private int contadorId = 0;

    public ClienteRepository() {
        this.clientes = new HashSet<>();
    }


    @Override
    public Cliente guardar(Cliente objeto) {
        this.clientes.add(objeto);
        System.out.println(objeto.toString());
        System.out.println("Se guardo exitosamente el Cliente.");
        return objeto;
    }

    @Override
    public Cliente buscar(int dni) {
        return clientes.stream().filter(cliente -> cliente.getDni() == dni)
                .findFirst().orElse(new Cliente());
    }

    public Set<Cliente> obtenerTodos(){
        return clientes;
    }
}
