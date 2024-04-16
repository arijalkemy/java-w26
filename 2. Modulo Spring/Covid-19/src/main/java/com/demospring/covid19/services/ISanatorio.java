package com.demospring.covid19.services;

import com.demospring.covid19.dtos.PersonaConSintomaDTO;
import com.demospring.covid19.models.Sintoma;

import java.util.List;

public interface ISanatorio {
    List<Sintoma> getSintomas();
    Sintoma getSintoma(int codigo);
    List<PersonaConSintomaDTO> getPersonasConSintomas();
}
