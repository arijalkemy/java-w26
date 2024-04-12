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

    public void add(Locator locator) {


        locators.add(locator);
    }
}
