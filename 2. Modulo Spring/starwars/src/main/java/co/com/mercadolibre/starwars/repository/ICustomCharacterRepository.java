package co.com.mercadolibre.starwars.repository;

import co.com.mercadolibre.starwars.entity.CustomCharacter;

public interface ICustomCharacterRepository {

    public CustomCharacter findByName(String name);
}
