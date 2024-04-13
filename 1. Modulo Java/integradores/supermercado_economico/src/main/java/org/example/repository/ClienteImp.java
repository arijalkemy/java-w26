package org.example.repository;

import org.example.models.Cliente;

import java.util.*;

public class ClienteImp implements ICRUDRepository<Cliente>{

    private Set<Cliente> clientes = new HashSet<>();

    public Cliente buscarClientePorDNI(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite dni del cliente: ");
        long dni = sc.nextLong();
        Cliente clienteEncontrado = clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findFirst()
                .orElse(null);
        return clienteEncontrado;
    }

    @Override
    public boolean save(Cliente c) {
        return clientes.add(c);
    }

    @Override
    public boolean delete(Cliente c) {
        return clientes.remove(c);
    }

    @Override
    public Optional<Cliente> findById(Long dni) {
        return clientes.stream()
                .filter(c -> c.getDni().equals(dni))
                .findFirst();
    }

    @Override
    public void imprimirLista() {
        System.out.println("Lista de clientes:");
        clientes.forEach(System.out::println);
    }

    @Override
    public Set<Cliente> findAll() {
        return clientes;
    }
}
