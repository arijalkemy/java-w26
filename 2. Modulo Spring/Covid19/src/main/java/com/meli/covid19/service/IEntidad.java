package com.meli.covid19.service;

import com.meli.covid19.dto.PersonaDTO;
import com.meli.covid19.dto.SintomaDTO;

import java.util.List;

public interface IEntidad {
    public List<SintomaDTO> findSymptom();
    public SintomaDTO findSymptom(String name);
    public List<PersonaDTO> findRiskPerson(String name);
}
