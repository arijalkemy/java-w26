package org.miprimerproyecto.starwarsvivo.repository;

import org.miprimerproyecto.starwarsvivo.model.Persona;

import java.util.List;

public interface IPersonaRepository {
    List<Persona> getPersonas();
}
