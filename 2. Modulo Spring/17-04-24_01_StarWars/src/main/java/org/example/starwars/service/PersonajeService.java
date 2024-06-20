package org.example.starwars.service;


import org.example.starwars.entity.Personaje;
import org.example.starwars.dto.PersonajeResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {

    private List<Personaje> cargarPersonajes() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeReference = new TypeReference<List<Personaje>>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/starwars.json");
        return mapper.readValue(inputStream, typeReference);
    }

    public List<PersonajeResponse> buscarPersonajes(String palabra) throws IOException {
        List<Personaje> personajes = cargarPersonajes();
        return personajes.stream()
                .filter(p -> p.getName().toLowerCase().contains(palabra.toLowerCase()))
                .map(p -> new PersonajeResponse(p.getName(), p.getHeight(), p.getMass(), p.getGender(), p.getHomeworld(), p.getSpecies()))
                .collect(Collectors.toList());
    }
}


