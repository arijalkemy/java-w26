package com.mercadolibre.starwars.service;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
  @Mock
  private CharacterRepositoryImpl characterRepository;

  @InjectMocks
  private FindService findService;


  @Test
  public void findReturnsCharactersWhoMatchTheQuery() {
    // Arrange
    CharacterDTO luke = new CharacterDTO();
    luke.setName("Luke Skywalker");

    when(characterRepository.findAllByNameContains("Luke")).thenReturn(List.of(luke));

    // Act
    List<CharacterDTO> result = findService.find("Luke");

    // Assert
    assertEquals(1, result.size());
    assertEquals("Luke Skywalker", result.get(0).getName());
  }

  @Test
  public void findReturnsEmptyListWhenNoCharactersMatchTheQuery() {
    // Arrange
    when(characterRepository.findAllByNameContains("NonExistent")).thenReturn(emptyList());

    // Act
    List<CharacterDTO> result = findService.find("NonExistent");

    // Assert
    assertTrue(result.isEmpty());
  }
}
