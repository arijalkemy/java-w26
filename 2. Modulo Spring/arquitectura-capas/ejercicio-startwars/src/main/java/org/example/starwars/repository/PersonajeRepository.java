package org.example.starwars.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.starwars.dto.PersonajeJsonDTO;
import org.example.starwars.model.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Repository
public class PersonajeRepository {

    private final List<Personaje> personajes;

    public PersonajeRepository() {

        try {
            File file = ResourceUtils.getFile("classpath:static/starwars.json");
            PersonajeJsonDTO[] personajesArray = new ObjectMapper().readValue(file, PersonajeJsonDTO[].class);

            this.personajes = Arrays.stream(personajesArray)
                .map(PersonajeRepository::convertirJsonDto)
                .toList();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Personaje convertirJsonDto(PersonajeJsonDTO jsonDTO) {
        return new Personaje(
            jsonDTO.getName(),
            jsonDTO.getHeight(),
            jsonDTO.getMass(),
            jsonDTO.getHair_color(),
            jsonDTO.getSkin_color(),
            jsonDTO.getEye_color(),
            jsonDTO.getBirth_year(),
            jsonDTO.getGender(),
            jsonDTO.getHomeworld(),
            jsonDTO.getSpecies()
        );
    }


    public List<Personaje> buscarTodos() {
        return personajes;
    }

    public List<Personaje> buscarPorNombre(String nombre) {
        return personajes.stream()
            .filter(p ->
                p.getName().toLowerCase().contains(nombre.toLowerCase())
            )
            .toList();
    }
}
