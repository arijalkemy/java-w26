package com.spring.deportistas_dto_ej.Services.SportsServiceImpl;

import com.spring.deportistas_dto_ej.Dtos.PersonaDto;
import com.spring.deportistas_dto_ej.Models.Deporte;
import com.spring.deportistas_dto_ej.Models.Persona;
import com.spring.deportistas_dto_ej.Services.ISportsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class SportsServiceImpl implements ISportsService {

    private List<Persona> personas;
    private List<Deporte> deportes;

    public SportsServiceImpl(){
        personas = new ArrayList<>();
        personas.add(new Persona("Lucas", "Martinez", 24));
        personas.add(new Persona("Juan", "Dominguez", 19));
        personas.add(new Persona("Pedro", "Gonzalez", 43));

        deportes = new ArrayList<>();
        deportes.add(new Deporte("Futbol", "Profesional"));
        deportes.add(new Deporte("Basket", "Amateur"));
        deportes.add(new Deporte("Handball", "SemiProfesional"));
    }

    @Override
    public List<Deporte> findSports() {
        return deportes;
    }

    @Override
    public Optional<Deporte> findSport(String name) {
        return deportes.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public List<PersonaDto> findSportsPersons() {
        List<PersonaDto> personasDto = new ArrayList<>();

        Random random = new Random();
        for (Persona persona : personas){
            int deporteRandomIndex = random.nextInt(deportes.size());
            personasDto.add(
                    new PersonaDto(
                            persona.getNombre(),
                            persona.getApellido(),
                            deportes.get(deporteRandomIndex).getNombre()
                    )
            );
        }

        return personasDto;
    }
}
