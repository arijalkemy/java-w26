package repositorios;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioCliente implements Repositorio<Cliente>
{
    List<Cliente> clienteList = new ArrayList<>();

    @Override
    public Optional<Cliente> buscarPorId(String id) {
        Optional<Cliente> cliente = clienteList.stream().filter(cl -> cl.getDni().equals(id)).findAny();

        return cliente;
    }

    @Override
    public void guardar(Cliente cliente) {
        clienteList.add(cliente);
    }

    @Override
    public void eliminar(Cliente elemento) {
        clienteList.remove(elemento);
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return clienteList;
    }
}
