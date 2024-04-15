package meli.bootcamp.implementaciones;

import meli.bootcamp.entidades.Cliente;
import meli.bootcamp.interfaces.ICrud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ClienteImp  implements ICrud<Cliente> {
    private List<Cliente> clientes;

    public ClienteImp() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void save(Cliente... clientes) {
        this.clientes.addAll(Arrays.stream(clientes).toList());
    }

    @Override
    public List<Cliente> findAll() {
        clientes.forEach(System.out::println);
        return clientes;
    }

    @Override
    public void delete(Cliente cliente) {
        clientes.remove(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        clientes.removeIf(x -> x.getDni().equals(cliente.getDni()));
        save(cliente);
    }

    @Override
    public Cliente findById(Long id) {
        return clientes.stream().filter(c -> c.getDni().equals(id)).findFirst().orElse(null);
    }

    public boolean search(Cliente cliente) {
        return clientes.contains(cliente);
    }
}