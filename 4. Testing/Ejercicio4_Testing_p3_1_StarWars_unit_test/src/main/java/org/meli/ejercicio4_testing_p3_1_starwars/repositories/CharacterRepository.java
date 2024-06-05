package org.meli.ejercicio4_testing_p3_1_starwars.repositories;


import org.meli.ejercicio4_testing_p3_1_starwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterRepository {
  List<CharacterDTO> findAllByNameContains(String query);
}
