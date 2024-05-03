package org.tests.starwars.service;


import org.springframework.stereotype.Service;
import org.tests.starwars.dto.CharacterDTO;
import org.tests.starwars.repositories.CharacterRepository;

import java.util.List;

@Service
public class FindService {

  private final CharacterRepository characterRepository;

  public FindService(CharacterRepository characterRepository) {
    this.characterRepository = characterRepository;
  }

  public List<CharacterDTO> find(String query) {
    return characterRepository.findAllByNameContains(query);
  }
}
