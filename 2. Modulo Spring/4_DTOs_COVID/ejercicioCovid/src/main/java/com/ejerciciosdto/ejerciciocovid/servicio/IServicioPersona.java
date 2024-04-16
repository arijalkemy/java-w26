package com.ejerciciosdto.ejerciciocovid.servicio;

import com.ejerciciosdto.ejerciciocovid.dto.PersonaDTO;
import com.ejerciciosdto.ejerciciocovid.entidades.Persona;

import java.util.List;

public interface IServicioPersona {
    public List<PersonaDTO> getPersonaEnRiesgo();
}
