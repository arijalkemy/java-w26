package com.ejercicio.covid19.services.interfaces;

import com.ejercicio.covid19.DTOs.RiskPerson;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPersonsService {
    public List<RiskPerson> getRiskPersons();
}
