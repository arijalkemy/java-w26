package org.ggomezr.deportistas.application.service.interfaces;

import org.ggomezr.deportistas.domain.dto.PersonaDTO;
import org.ggomezr.deportistas.domain.entity.Persona;

import java.util.List;

public interface IPersonaService {
    List<PersonaDTO> findSportsPersons();
}
