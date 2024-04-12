package org.example.Ejercicios_Integradores_P1.SINC;

import lombok.Data;
import org.example.Ejercicios_Integradores_P1.SINC.Repository.RepositoryLocator;


@Data
public class Agency {

    private final RepositoryLocator repo;

    public Agency(RepositoryLocator repo) {
        this.repo = repo;
    }
}
