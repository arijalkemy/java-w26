package org.example.Ejercicios_Integradores_P1.SINC.Agency.Repository;

import lombok.Getter;
import org.example.Ejercicios_Integradores_P1.SINC.Agency.Client;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RepositoryClient {

    private final  List<Client> clients = new ArrayList<>();

    public void add(Client client) {
        if (!clients.contains(client))
            clients.add(client);
    }
}
