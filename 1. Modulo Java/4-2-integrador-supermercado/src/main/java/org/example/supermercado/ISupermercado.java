package org.example.supermercado;

import org.example.Cliente;

import java.util.Optional;

public interface ISupermercado {

    Optional<Cliente> getCliente(int dni);

    void getClientes();

    void addCliente(Cliente cliente);

    Cliente updateCliente(Cliente cliente);

    void deleteCliente(Cliente cliente);
}
