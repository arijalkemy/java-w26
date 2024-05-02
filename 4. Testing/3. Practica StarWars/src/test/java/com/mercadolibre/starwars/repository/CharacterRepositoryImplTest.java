package com.mercadolibre.starwars.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryImplTest {
  CharacterRepositoryImpl characterRepositoryImpl;

  @Test
  public void loadDatabaseShouldNotThrowException() {
    assertDoesNotThrow(CharacterRepositoryImpl::new);
  }

}
