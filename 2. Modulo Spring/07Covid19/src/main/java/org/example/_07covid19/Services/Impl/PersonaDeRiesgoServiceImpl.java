package org.example._07covid19.Services.Impl;

import org.example._07covid19.Persona;
import org.example._07covid19.Services.IPersonasDeRiesgoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaDeRiesgoServiceImpl implements IPersonasDeRiesgoService {
    /*
    Obtiene la lista de personas de riesgo a partir de una lista de todas las personas con sus síntomas
    Las personas de riesgo son aquellas mayores de 60 años que posean al menos un síntoma
     */
    @Override
    public List<Persona> obtener(List<Persona> personas) {
        return personas.stream().filter(p -> p.getEdad() > 60 && !p.getSintomas().isEmpty()).toList();
    }
}
