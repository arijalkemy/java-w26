package org.example.Collections;

import org.example.Model.Cliente;

import java.util.ArrayList;
import java.util.Arrays;

public class ClienteCollection implements Actions {

    ArrayList<Cliente> clientes;

    public ClienteCollection(Cliente ...clientes) {
        this.clientes = new ArrayList<>(Arrays.asList(clientes));
    }

    @Override
    public void guardar(Object cliente) {
        this.clientes.add((Cliente) cliente);
    }

    @Override
    public void mostrar() {
        for (Cliente cliente : this.clientes) {
            System.out.println(cliente);
        }
    }

    @Override
    public Object buscar(String dni) {
        return this.clientes.stream().filter(p-> p.getDni().equals(dni)).findFirst().orElse(null);
    }

    @Override
    public void eliminar(String dni) {
        Cliente deletedClient = (Cliente) this.buscar(dni);
        boolean removed = this.clientes.removeIf( p -> p.getDni().equals(dni) );

        if (removed){
            System.out.println("El Cliente " + deletedClient.getNombre() + " " + deletedClient.getApellido() + " Fue eliminado");
        }
    }

}
