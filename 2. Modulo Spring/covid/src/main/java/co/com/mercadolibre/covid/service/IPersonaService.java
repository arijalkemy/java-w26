package co.com.mercadolibre.covid.service;

import co.com.mercadolibre.covid.dto.PersonaConRiesgoDto;

import java.util.List;

public interface IPersonaService {

    List<PersonaConRiesgoDto> listar();
}
