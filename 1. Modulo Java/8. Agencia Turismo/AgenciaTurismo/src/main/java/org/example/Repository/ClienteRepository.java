package org.example.Repository;

import org.example.Class.Cliente;
import org.example.Class.Localizador;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private static List<Cliente> clientesList = new ArrayList<Cliente>();

    public void agregar(Cliente cliente){
        clientesList.add(cliente);
    }

    public Cliente getByDni(final String dni){
       return clientesList.stream().filter(c -> c.getDni().equals(dni)).findFirst().get();
    }
}
