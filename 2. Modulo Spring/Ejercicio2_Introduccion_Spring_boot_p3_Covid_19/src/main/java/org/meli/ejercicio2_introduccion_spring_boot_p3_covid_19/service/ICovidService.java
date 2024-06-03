package org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.service;

import org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.dto.SymptomDTO;
import org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.dto.SymptomPersonDTO;

import java.util.List;
import java.util.Set;

public interface ICovidService {
    public Set<SymptomDTO> getAllSymptoms();
    public Set<SymptomDTO>  getSymptomById(String symptoms);
    public Set<SymptomPersonDTO> listSymptomsAssociatedPeople();

}
