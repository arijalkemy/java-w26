package org.example.Ejercicios_Integradores_P1.SINC.Agency;

import lombok.Data;
import org.example.Ejercicios_Integradores_P1.SINC.Agency.Repository.RepositoryClient;
import org.example.Ejercicios_Integradores_P1.SINC.Agency.Repository.RepositoryLocator;


@Data
public class Agency {

    private final RepositoryLocator locatorRepository;
    private final RepositoryClient clientRepository;

    public Agency(RepositoryLocator locatorRepository, RepositoryClient clientRepository) {
        this.locatorRepository = locatorRepository;
        this.clientRepository = clientRepository;
    }

    public void registerClient(Client newClient){
        this.getClientRepository().add(newClient);
    }

    public void registerLocator(Locator locator){
        //caso 1
        int countClient = this.getLocatorRepository().getLocators().stream().filter(l -> l.getClient().equals(locator.getClient())).toArray().length;
        //le sumo 1 al contador de clientes porque sino no me lo toma en la 2da vuelta
        if (countClient + 1 >= 2)
            this.getClientRepository().update(locator.getClient().getId(), locator.getClient());

        this.locatorRepository.add(locator);
    }
}
