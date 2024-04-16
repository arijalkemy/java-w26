package org.ejercicio.personasdeportes.service;

import org.ejercicio.personasdeportes.model.Deporte;
import org.ejercicio.personasdeportes.model.Persona;
import org.ejercicio.personasdeportes.model.dto.DeportistaDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Deportistarepository {
    public static List<Persona> personas = Arrays.asList(new Persona("Lionel","Messi",39,SportRepository.deportes.get(0)),
            new Persona("Lebron","James",37,SportRepository.deportes.get(1)),
            new Persona("Michael","Phelps", 40, SportRepository.deportes.get(2)));

    public List<DeportistaDTO> findSportsPersons(){
        return personas.stream().map( p -> new DeportistaDTO(p.getNombre(),p.getApellido(),p.getDeporte().getNombre())).collect(Collectors.toList());
    }
}
