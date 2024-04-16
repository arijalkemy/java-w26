package co.com.mercadolibre.covid.repository;


import co.com.mercadolibre.covid.dto.PersonaConRiesgoDto;

import java.util.List;

public interface IPersonaRepository {

    List<PersonaConRiesgoDto> personasConRiego();
}
