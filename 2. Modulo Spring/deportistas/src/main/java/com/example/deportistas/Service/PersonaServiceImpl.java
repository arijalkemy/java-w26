package com.example.deportistas.Service;

import com.example.deportistas.Entity.Deporte;
import com.example.deportistas.Entity.Persona;
import com.example.deportistas.DTO.PersonaDeportista;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class PersonaServiceImpl implements PersonaService{


    private static Map<Integer, Deporte> deportes = Stream.of(
                        new AbstractMap.SimpleEntry<>( 1, new Deporte(1,"Natacion", 10)),
                        new AbstractMap.SimpleEntry<>( 2, new Deporte(2, "Esgrima", 9)),
                        new AbstractMap.SimpleEntry<>( 3, new Deporte(3, "Arqueria", 8)),
                        new AbstractMap.SimpleEntry<>( 4, new Deporte(4, "Futbol", 12))
                    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private static List<Persona> personas = List.of(
            new Persona("Isay","Balderas", 20, 1),
            new Persona("Emiliano","Balderas", 18, 2),
            new Persona("Pepe","Ramirez", 40, 3),
            new Persona("Sergio","Fernandez", 24, 0)
    );

    @Override
    public String personasDeportistas() {
        List<PersonaDeportista> personasConDeporte = new ArrayList<>();
        for(Persona persona: personas){
            if(persona.getDeporte() != 0)
                personasConDeporte.add(new PersonaDeportista(
                        persona.getNombre(),
                        persona.getApellido(),
                        deportes.get(persona.getDeporte()).getNombre()));
        }
        String aux = "";
        for(PersonaDeportista personaDeportista: personasConDeporte){
            aux += "- " + personaDeportista.getNombre() +
                    "\n- " + personaDeportista.getApellido() +
                    "\n- " + personaDeportista.getNombreDeporte() + "\n";
        }
        return aux;
    }
}
