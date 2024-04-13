package com.example.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.store.Client;

public class ClientCRUD implements ICrud<Client> {

    List<Client> clientRepository;

    public ClientCRUD() {
        clientRepository = new ArrayList<>();
    }

    @Override
    public void save(Client client) {
        try {
            clientRepository.add(client);
        } catch (Exception e) {
            System.out.println("Error al guardar al cliente - Err: " + e.getMessage());
        }
    };

    @Override
    public void show(Client client) {
        System.out.println(client.toString());
    };

    @Override
    public Optional<Client> get(String id) {
        for (Client client : clientRepository) {
            if (client.getDni().equals(id)) {
                return Optional.of(client);
            }
        }
        return Optional.empty();
    };

    @Override
    public void delete(String id) {
        for (Client client : clientRepository) {
            if (client.getDni().equals(id)) {
                clientRepository.remove(client);
            }
        }
    }

    @Override
    public List<Client> getAll() {
        return this.clientRepository;
    };

}
