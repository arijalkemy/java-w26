package com.example.repository;

import com.example.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepository implements IRepository<Client> {

    private List<Client> clients;

    public ClientRepository() {
        clients = new ArrayList<>();
    }

    @Override
    public void save(Client client) {
        try {
            this.clients.add(client);
        } catch (Exception e) {
            System.out.println("Error al guardar un client: Error - " + e.getMessage());
        }
    }

    @Override
    public void show(Client client) {
        System.out.println(client.toString());
    }

    @Override
    public Optional<Client> get(String id) {
        return this.clients.stream()
                .filter(client -> client.getDni().equals(id))
                .findFirst();
    }

    @Override
    public void delete(String id) {
        this.clients.removeIf(client -> client.getDni().equals(id));
    }

    @Override
    public List<Client> getAll() {
        return this.getAll();
    }

}
