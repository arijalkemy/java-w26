package co.com.mercadolibre.starwars.service;

import co.com.mercadolibre.starwars.dto.CustomCharacterDto;
import co.com.mercadolibre.starwars.exception.DataTypeException;

public interface ICustomCharacterService {

    CustomCharacterDto findByName(String name);
}
