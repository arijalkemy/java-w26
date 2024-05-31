package com.Ejercicio.Deportistas.Service;

import com.Ejercicio.Deportistas.DTO.SportDTO;
import com.Ejercicio.Deportistas.Entity.Sport;
import com.Ejercicio.Deportistas.Exception.NotFoundException;
import com.Ejercicio.Deportistas.Repository.SportRepositoryImpl;
import org.assertj.core.condition.Not;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SportServiceTest {

    @Autowired
    private SportRepositoryImpl sportRepository;

    @Autowired
    private SportServiceImpl sportService;

    private ModelMapper modelMapper = new ModelMapper();

    private static List<Sport> sports;

    @BeforeEach
    public void setup() {
        sports = new ArrayList<>();
        sports.add(new Sport("Futbol", "Profesional"));
        sports.add(new Sport("Baloncesto", "Amateur"));
        sports.add(new Sport("Tenis", "Profesional"));
        sports.add(new Sport("Natacion", "Recreativo"));
        sports.add(new Sport("Atletismo", "Profesional"));
    }

    @Test
    @DisplayName("Create a test list equals to sports list on repository and expected sportService return same list mapped to Dto")
    public void findAllSportsTest() {
        //Arrange
        List <SportDTO> expectedDtoList = sports.stream().map(sport -> modelMapper.map(sport, SportDTO.class)).collect(Collectors.toList());

        //Act
        List<SportDTO> sportDTOList = sportService.findAllSports();

        //Assert
        assertEquals(expectedDtoList, sportDTOList);
    }

    @Test
    @DisplayName("Declare a variable soccer as sport name and call findByName as service, that method should return the level that soccer has which is Professional.")
    public void findSportByNameTest(){
        //Arrange
        String sportName = "Futbol";
        String expectedResult = "Profesional";

        //Act
        String result = sportService.findSportBy(sportName);

        //Assert
        assertEquals(expectedResult, result);
    }


    @Test
    @DisplayName("Declare a sport variable with a non-existent sport, call findByName and it will return NotFoundException")
    public void findSportByNameNotFoundTest(){
        //Arrange
        String sportName = "Rugby";
        //Act and Assert
        assertThrows(NotFoundException.class, () -> sportService.findSportBy(sportName));
    }


    // test NotFoundException
        // realizar un test con un cazo de uso en concreto llamando a sportByName y pasandole un deporte que no existe y verificar si se lanza la excepcion NotFoundException
}
