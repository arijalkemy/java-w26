package co.com.mercadolibre.covid.service.impl;

import co.com.mercadolibre.covid.dto.PersonaConRiesgoDto;
import co.com.mercadolibre.covid.repository.IPersonaRepository;
import co.com.mercadolibre.covid.service.IPersonaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements IPersonaService {

    private IPersonaRepository repositorio;

    public PersonaService(IPersonaRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<PersonaConRiesgoDto> listar() {
        List<PersonaConRiesgoDto> personasFiltradasConRiesgo = this.repositorio.personasConRiego().stream()
                .filter(persona -> persona.getEdad() >= 60)
                .filter(persona -> persona.getSintomas().size() >= 2)
                .collect(Collectors.toList());
        return personasFiltradasConRiesgo;
    }
}
