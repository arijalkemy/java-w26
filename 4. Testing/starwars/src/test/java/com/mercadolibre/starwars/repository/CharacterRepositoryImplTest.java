package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CharacterRepositoryImplTest {

   private CharacterRepositoryImpl characterRepository;

   @BeforeEach
   public void setup(){
      this.characterRepository = new CharacterRepositoryImpl();
   }

   @Test
   @DisplayName("Devuelve una lista de personajes que contengan en su nombre una parte del parametro")
   void buscarTodosPersonajesPorNombre(){


      CharacterDTO luke = new CharacterDTO();
      luke.setName("Luke Skywalker");
      luke.setHair_color("blond");
      luke.setSkin_color("fair");
      luke.setEye_color("blue");
      luke.setBirth_year("19BBY");
      luke.setGender("male");
      luke.setHomeworld("Tatooine");
      luke.setSpecies("Human");
      luke.setHeight(172);
      luke.setMass(77);

      List<CharacterDTO> listaObtenida = this.characterRepository.findAllByNameContains("Luke");
      for (CharacterDTO character: listaObtenida){
         Assertions.assertEquals(luke.getName(), character.getName());
      }
   }


}
