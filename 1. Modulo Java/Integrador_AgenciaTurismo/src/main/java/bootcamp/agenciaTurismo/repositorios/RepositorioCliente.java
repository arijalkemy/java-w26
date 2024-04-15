package bootcamp.agenciaTurismo.repositorios;

import java.util.List;

import bootcamp.agenciaTurismo.cliente.Cliente;

import java.util.ArrayList;


public class RepositorioCliente {
    private static List<Cliente> clientes = new ArrayList<>();

    private RepositorioCliente(){

    }

    public static void add(Cliente entity) {
        if (!clientes.contains(entity)) {
            clientes.add(entity);
        }
    }

    public static List<Cliente> findAll() {
        return clientes;
    }

    public static boolean exist(int clientId) {
        return clientes.stream()
                    .anyMatch(client -> client.getId() == clientId);
    }
    

}
