package com.mercadolibre.starwars.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
  @Mock
  private FindService findService;

  @InjectMocks
  private FindController findController;

  @Test
  public void findReturnsCharactersWhoMatchTheQuery() {
    //Arrange
    String query = "Luke";

    CharacterDTO luke = new CharacterDTO();
    luke.setName("Luke Skywalker");
    luke.setHeight(172);
    luke.setMass(77);
    luke.setHair_color("blond");
    luke.setSkin_color("fair");
    luke.setEye_color("blue");
    luke.setBirth_year("19BBY");

    List<CharacterDTO> expected = List.of(luke);

    when(findService.find("Luke")).thenReturn(expected);

    //Act
    List<CharacterDTO> result = findController.find(query);

    //Assert
    assertEquals(expected, result);
  }

  @Test
  public void findReturnsEmptyListWhenQueryDoesNotMatch() {
    String query = "NonExistentCharacter";
    when(findService.find(query)).thenReturn(List.of());

    List<CharacterDTO> result = findController.find(query);

    assertEquals(List.of(), result);
  }
}
