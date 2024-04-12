package bootcamp.bendezujonathan.repositorios;

import java.util.List;
import java.util.ArrayList;

import bootcamp.bendezujonathan.cliente.Cliente;


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
