package org.ggomezr.starwars.domain.repository.interfaces;

import org.ggomezr.starwars.domain.entity.Character;

import java.io.IOException;
import java.util.List;

public interface ICharacterRepository {
    List<Character> getAllCharacters() throws IOException;
}
