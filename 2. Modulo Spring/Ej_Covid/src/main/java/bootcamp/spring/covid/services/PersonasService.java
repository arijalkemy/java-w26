package bootcamp.spring.covid.services;

import java.util.List;

import org.springframework.stereotype.Service;

import bootcamp.spring.covid.models.Persona;
import bootcamp.spring.covid.repositories.PersonasRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonasService {

    private final PersonasRepository personasRepository;

    public List<Persona> buscarPersonasMayores60() {
        return personasRepository
                .getAll()
                .stream()
                .filter(persona -> persona.getEdad() > 60)
                .toList();
    }
}
