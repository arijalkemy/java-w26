package com.ejerciciosdto.ejerciciocovid.servicio;

import com.ejerciciosdto.ejerciciocovid.dto.PersonaDTO;
import com.ejerciciosdto.ejerciciocovid.entidades.Sintoma;
import com.ejerciciosdto.ejerciciocovid.repositorio.CreadorInstancias;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioPersonaImpl implements IServicioPersona{
    CreadorInstancias creadorInstancias = new CreadorInstancias();
    List<Sintoma> sintomas = creadorInstancias.getSintomas();
    public List<PersonaDTO> getPersonaEnRiesgo() {
        List<PersonaDTO> personaDTO;
        personaDTO = creadorInstancias.getPersonas().stream().map(dto -> new PersonaDTO(dto.getId(),dto.getNombre(),
                dto.getApellido(), dto.getEdad(),sintomas)).toList();
        return  personaDTO.stream().filter(x ->x.getEdad() >= 60).toList();
    }

}
