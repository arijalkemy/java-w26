package bootcamp.spring.ej_star_wars.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import bootcamp.spring.ej_star_wars.models.dtos.PersonajeDTO;
import bootcamp.spring.ej_star_wars.repositories.PersonajeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonajeServiceImpl implements ExternalPersonajeService{

    private final PersonajeRepository personajeRepository;
    @Override
    public Optional<PersonajeDTO> getByName(String name) {
        return personajeRepository.findByName(name).map(PersonajeDTO::new);
    }


}
