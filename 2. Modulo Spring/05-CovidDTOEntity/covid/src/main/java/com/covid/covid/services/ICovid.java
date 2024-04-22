package com.covid.covid.services;

import com.covid.covid.models.Sintoma;
import com.covid.covid.models.dto.PersonasRiesgoDTO;
import com.covid.covid.models.dto.SintomaDTO;

import java.util.List;

public interface ICovid {
    public List<Sintoma> getSintomas();

    public SintomaDTO getSintomaPorNombre(String nombre);

    public List<PersonasRiesgoDTO> getPersonasRiesgo();


}
