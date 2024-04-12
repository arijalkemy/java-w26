package org.example.Ejercicios_Integradores_P1.SINC.Repository;

import lombok.Getter;
import org.example.Ejercicios_Integradores_P1.SINC.Client;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RepositoryClient {

    private List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        if (!clients.contains(client))
            clients.add(client);
    }

    public Client update(int idClient,Client client){
        Client clientToUpdate = clients.stream().filter(c -> c.getId() == idClient).findFirst().orElse(null);
        if(clientToUpdate != null){
            clientToUpdate.setDiscount(5);
        }

        //reemplazar el cliente en la lista segun el id
        clients.set(clients.indexOf(client), clientToUpdate);

        return clientToUpdate;

    }
}
