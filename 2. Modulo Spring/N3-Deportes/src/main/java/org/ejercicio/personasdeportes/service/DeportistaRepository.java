package org.ejercicio.personasdeportes.service;

import org.ejercicio.personasdeportes.model.Persona;
import org.ejercicio.personasdeportes.model.dto.DeportistaDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeportistaRepository {
    public static List<Persona> personas = Arrays.asList(new Persona("Lionel","Messi",39, DeporteRepository.deportes.get(0)),
            new Persona("Lebron","James",37, DeporteRepository.deportes.get(1)),
            new Persona("Michael","Phelps", 40, DeporteRepository.deportes.get(2)));

    public List<DeportistaDTO> findDeportePersona(){
        return personas.stream().map( p -> new DeportistaDTO(p.getNombre(),p.getApellido(),p.getDeporte().getNombre())).collect(Collectors.toList());
    }
}
