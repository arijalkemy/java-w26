package org.covid19.covid19.servicios;

import org.covid19.covid19.dto.PersonaDto;

import java.util.List;

public interface IPersonaServicio
{
     List<PersonaDto> obtenerPersonasDeRiesgo();
}
