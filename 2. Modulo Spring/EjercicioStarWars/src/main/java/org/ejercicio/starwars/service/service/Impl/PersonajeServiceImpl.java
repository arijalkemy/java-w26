package org.ejercicio.starwars.service.service.Impl;

import org.ejercicio.starwars.dto.PersonajeDTO;
import org.ejercicio.starwars.entity.Personaje;
import org.ejercicio.starwars.repositorio.RepositoryPersonaje;
import org.ejercicio.starwars.service.IPersonajeService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements IPersonajeService {




    @Override
    public List<PersonajeDTO> mostrarPersonajes(String name) throws IOException {
        List<Personaje> personajes = new ArrayList<Personaje>();
        List<PersonajeDTO> personajesDTO = new ArrayList<>();

        for (Personaje personaje : RepositoryPersonaje.obtenerPersonajesDeArchivos()) {
              personajes.add(new Personaje(
                      personaje.getName(),
                      personaje.getHeight(),
                      personaje.getMass(),
                      personaje.getHair_color(),
                      personaje.getSkin_color(),
                      personaje.getEye_color(),
                      personaje.getBirth_year(),
                      personaje.getGender(),
                      personaje.getHomeworld(),
                      personaje.getSpecies()
              ));
        }

        List<Personaje> personajeFiltrado= personajes.stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();

        for(Personaje personaje : personajeFiltrado) {

            personajesDTO.add(new PersonajeDTO(
                    personaje.getName(),
                    personaje.getHeight(),
                    personaje.getMass(),
                    personaje.getGender(),
                    personaje.getHomeworld(),
                    personaje.getSpecies()
            ));
        }
        System.out.println("Lista de personajes filtrados DTO: ");
        for (PersonajeDTO personaje : personajesDTO) {
            System.out.println("Nombre: " + personaje.getName());
        }
        return personajesDTO;
    }

}
