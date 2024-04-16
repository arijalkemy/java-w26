package co.com.mercadolibre.covid.repository.impl;

import co.com.mercadolibre.covid.dto.PersonaConRiesgoDto;
import co.com.mercadolibre.covid.entity.Persona;
import co.com.mercadolibre.covid.entity.Sintoma;
import co.com.mercadolibre.covid.repository.IPersonaRepository;
import co.com.mercadolibre.covid.repository.ISintomaRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class PersonaRepository implements IPersonaRepository {

    private ISintomaRepository sintomaRepository;

    public PersonaRepository(ISintomaRepository sintomaRepository) {
        this.sintomaRepository = sintomaRepository;
    }

    @Override
    public List<PersonaConRiesgoDto> personasConRiego() {
        List<PersonaConRiesgoDto> personas = this.devolverListaDePersonas(this.sintomaRepository.buscarTodos());
        return personas;
    }

    private List<PersonaConRiesgoDto> devolverListaDePersonas(List<Sintoma> sintomas) {
        List<PersonaConRiesgoDto> personas = new ArrayList<>();
        Faker faker = new Faker();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Persona persona = new Persona();
            persona.setId(i);
            persona.setNombre(faker.name().name());
            persona.setApellido(faker.name().lastName());
            persona.setEdad(random.nextInt(70 - 18 + 1) + 18);

            Integer numSintomas = random.nextInt(3) + 1;
            List<Sintoma> sintomasPersona = new ArrayList<>();
            for (int j = 0; j < numSintomas; j++) {
                sintomasPersona.add(sintomas.get(j));
            }
            persona.setListaDeSintomas(sintomasPersona);

            PersonaConRiesgoDto personaDto = this.mapearPersonaConRiesgoDto(persona);
            personas.add(personaDto);
        }

        return personas;
    }


    private PersonaConRiesgoDto mapearPersonaConRiesgoDto(Persona persona) {
        PersonaConRiesgoDto personaDto = new PersonaConRiesgoDto();
        personaDto.setNombre(persona.getNombre());
        personaDto.setApellido(persona.getApellido());
        personaDto.setEdad(persona.getEdad());
        personaDto.setSintomas(persona.getListaDeSintomas());
        return personaDto;
    }
}
