package org.example.Ejercicios_Integradores_P1.SINC.Agency.Repository;

import lombok.Getter;
import org.example.Ejercicios_Integradores_P1.SINC.Agency.Client;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RepositoryClient {

    private List<Client> clients = new ArrayList<>();

    public void add(Client client) {
        if (!clients.contains(client))
            clients.add(client);
    }

    public Client update(int idClient,Client client){
        Client clientToUpdate = clients.stream().filter(c -> c.getId() == idClient).findFirst().orElse(null);
        if(clientToUpdate != null){
            clientToUpdate.setDiscount(5);
        }
        clients.set(clients.indexOf(client), clientToUpdate);
        return clientToUpdate;

    }
}
