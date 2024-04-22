package org.miprimerproyecto.starwarsvivo.services;

import org.miprimerproyecto.starwarsvivo.dto.PersonaDTO;

import java.util.List;

public interface PersonaService {
     List<PersonaDTO> findAll(String nombre);

}
