package org.example.ejercicio_covid.services;

import org.example.ejercicio_covid.dto.RiskPersonDTO;
import org.example.ejercicio_covid.models.Symptom;

import java.util.*;

public interface ICovidSevice {
    public List<Symptom> findSymptom();
    public Symptom findSymptom(String name);
    public List<RiskPersonDTO> findRiskPerson();
}
