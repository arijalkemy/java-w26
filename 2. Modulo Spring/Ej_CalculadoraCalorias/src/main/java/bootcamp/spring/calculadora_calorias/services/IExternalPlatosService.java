package bootcamp.spring.calculadora_calorias.services;

import java.util.Optional;

import javax.naming.NameNotFoundException;

import bootcamp.spring.calculadora_calorias.models.dtos.PlatoDTO;

public interface IExternalPlatosService{
    Optional<PlatoDTO> searchByNameWithCalories (String name, Integer calories) throws NameNotFoundException ;
}
