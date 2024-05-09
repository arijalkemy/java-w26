package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    CalculateRestController calculateRestController = new CalculateRestController();

    @Test
    @DisplayName("Verificar que HouseResponse no sea null al calcular el precio")
    public void CalculateRestController_calculate_HouseResponseShouldBeNotNull(){
        RoomDTO room1 = RoomDTO.builder().name("Room 1").width(20).length(10).build();
        RoomDTO room2 = RoomDTO.builder().name("Room 2").width(30).length(15).build();

        List<RoomDTO> rooms = Arrays.asList(room1, room2);

        HouseDTO house = HouseDTO.builder().name("House").address("Av. 232").rooms(rooms).build();

        HouseResponseDTO response = calculateRestController.calculate(house);

        Assertions.assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("Verificar que el calculo del precio de la propiedad sea correcto")
    public void CalculateRestController_calculate_priceShouldBeCorrect(){
        RoomDTO room1 = RoomDTO.builder().name("Room 1").width(20).length(10).build();
        RoomDTO room2 = RoomDTO.builder().name("Room 2").width(30).length(15).build();

        List<RoomDTO> rooms = Arrays.asList(room1, room2);

        HouseDTO house = HouseDTO.builder().name("House").address("Av. 232").rooms(rooms).build();

        HouseResponseDTO response = calculateRestController.calculate(house);

        Assertions.assertThat(response.getPrice()).isEqualTo(520000);
    }

    @Test
    @DisplayName("Verificar que los metros cuadrados y el precio sean mayores a cero")
    public void CalculateRestController_calculate_SquareFeetAndPriceShouldBeGreaterThanZero(){
        RoomDTO room1 = RoomDTO.builder().name("Room 1").width(20).length(10).build();
        RoomDTO room2 = RoomDTO.builder().name("Room 2").width(30).length(15).build();

        List<RoomDTO> rooms = Arrays.asList(room1, room2);

        HouseDTO house = HouseDTO.builder().name("House").address("Av. 232").rooms(rooms).build();

        HouseResponseDTO response = calculateRestController.calculate(house);

        Assertions.assertThat(response.getSquareFeet()).isGreaterThan(0);
        Assertions.assertThat(response.getPrice()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Verificar la Biggest Room no sea null y sea comparable")
    public void CalculateRestController_calculate_biggestRoomShouldExists(){
        RoomDTO room1 = RoomDTO.builder().name("Room 1").width(20).length(10).build();
        RoomDTO room2 = RoomDTO.builder().name("Room 2").width(30).length(15).build();

        List<RoomDTO> rooms = Arrays.asList(room1, room2);

        HouseDTO house = HouseDTO.builder().name("House").address("Av. 232").rooms(rooms).build();

        HouseResponseDTO response = calculateRestController.calculate(house);

        Assertions.assertThat(response.getBiggest()).isNotNull();
        assertEquals(response.getBiggest(), room2);
    }

    @Test
    @DisplayName("Verificar que los metros cuadrados sean calculados correctamente")
    public void CalculateRestController_calculate_squareFeetShouldBeRight(){
        RoomDTO room1 = RoomDTO.builder().name("Room 1").width(20).length(10).build();
        RoomDTO room2 = RoomDTO.builder().name("Room 2").width(30).length(15).build();

        List<RoomDTO> rooms = Arrays.asList(room1, room2);

        HouseDTO house = HouseDTO.builder().name("House").address("Av. 232").rooms(rooms).build();

        HouseResponseDTO response = calculateRestController.calculate(house);

        Assertions.assertThat(response.getSquareFeet()).isEqualTo(650);
    }

    @Test
    @DisplayName("Verificar que se lance la excepcion si las room son null")
    public void CalculateRestController_calculate_ShouldThrowNullPointerException(){
        List<RoomDTO> rooms = Arrays.asList(null, null);

        HouseDTO house = HouseDTO.builder().name("House").address("Av. 232").rooms(rooms).build();

        assertThrows(NullPointerException.class, () -> calculateRestController.calculate(house));
    }
}
