package com.mercadolibre.starwars.controller;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.commons.collections4.CollectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FindControllerTests {
    private String name;
    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @BeforeEach
    public void setUp(){
        name = "Luke";
    }

    @Test
    @DisplayName("Obtener todos los personajes que contienen un fragmento del nombre solicitado de manera exitosa")
    public void findAllByNameContains(){
        //Arrange
        List<CharacterDTO> characters = TestUtilsGenerator.getAllByNameContains(name);
        //Act
        List<CharacterDTO> foundSet = findController.find(name);
        //Assert
        verify(findService, atLeastOnce()).find(name);
    }
}
