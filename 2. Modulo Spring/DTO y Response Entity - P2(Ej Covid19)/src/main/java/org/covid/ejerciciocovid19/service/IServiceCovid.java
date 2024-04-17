package org.covid.ejerciciocovid19.service;

import org.covid.ejerciciocovid19.model.PersonaSintomaDTO;
import org.covid.ejerciciocovid19.model.Sintoma;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface IServiceCovid {

    public List<Sintoma> findSintomas();
    public int findSintomaByName(String name);

    public List<PersonaSintomaDTO> findRiskPersons();
}
