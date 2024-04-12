package org.example.Ejercicios_Integradores_P1.SINC.Repository;

import lombok.Getter;
import org.example.Ejercicios_Integradores_P1.SINC.Locator;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RepositoryLocator {
    private final List<Locator> locators;
    private final RepositoryClient repoClient;

    public RepositoryLocator(RepositoryClient repoClient) {
        this.repoClient = repoClient;
        this.locators = new ArrayList<>();
    }

    public void addLocator(Locator locator) {
        repoClient.addClient(locator.getClient());
        //caso 1
        int countClient = locators.stream().filter(client -> client.getClient().equals(locator.getClient())).toArray().length;
        if (countClient >= 2)
            repoClient.update(locator.getClient().getId(), locator.getClient());

        locators.add(locator);
    }
}
