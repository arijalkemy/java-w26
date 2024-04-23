package com.mercadolibre.Covid19API.services.implementation;

import com.mercadolibre.Covid19API.DTO.PersonaDTO;
import com.mercadolibre.Covid19API.model.Persona;
import com.mercadolibre.Covid19API.repository.RepoBD;
import com.mercadolibre.Covid19API.services.IPersonaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {
    @Override
    public List<PersonaDTO> visualizarPersonasGrupoDeRiesgo() {
        List<PersonaDTO> grupoDeRiesgo = new ArrayList<>();
        for (Persona p : RepoBD.personas){
            grupoDeRiesgo.add(new PersonaDTO(p.getNombre()+" "+p.getApellido(),p.getEdad(),p.getpSintomas()));
        }
        return grupoDeRiesgo;
    }
}
