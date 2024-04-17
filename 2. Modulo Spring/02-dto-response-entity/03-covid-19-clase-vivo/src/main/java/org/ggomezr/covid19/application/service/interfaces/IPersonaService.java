package org.ggomezr.covid19.application.service.interfaces;

import org.ggomezr.covid19.domain.dto.PersonaRiesgoDTO;

import java.util.List;

public interface IPersonaService {
    List<PersonaRiesgoDTO> findRiskPerson();
}
