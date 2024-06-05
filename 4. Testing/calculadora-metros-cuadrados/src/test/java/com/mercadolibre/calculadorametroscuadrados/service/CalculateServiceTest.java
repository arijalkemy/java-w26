package com.mercadolibre.calculadorametroscuadrados.service;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculateServiceTest {


    private final CalculateService service = new CalculateService();
    private HouseDTO house;

    @BeforeEach
    void setUp()
    {
        house =   new HouseDTO("Lomas de la estancia", "reforma 22",  List.of());
    }

    @Test
    void testCalculateMethodSendingAEmptyRoom()
    {
        // arrange
        List<RoomDTO> rooms = List.of();
        house.setRooms(rooms);

        // act
        HouseResponseDTO response = service.calculate(house);

        //assert
        assertEquals(0, response.getSquareFeet());
    }

    @Test
    void testCalculateMethodSendingAUniqueRoom() {
        // arrange
        List<RoomDTO> rooms = List.of(
                new RoomDTO("sala", 10, 11)
        );
        house.setRooms(rooms);

        // act
        HouseResponseDTO response = service.calculate(house);

        // assert
        assertEquals(110, response.getSquareFeet());
    }

    @Test
    void testCalculateMethodSendingMultipleRooms() {
        // arrange
        List<RoomDTO> rooms = List.of(
                new RoomDTO("sala", 10, 11),
                new RoomDTO("cocina", 5, 5),
                new RoomDTO("baño", 3, 3)
        );
        house.setRooms(rooms);

        // act
        HouseResponseDTO response = service.calculate(house);

        // assert
        assertEquals(144, response.getSquareFeet());
    }

    @Test
    void verifyBiggestRoom()
    {
        // arrange
        List<RoomDTO> rooms = List.of(
                new RoomDTO("sala", 10, 11),
                new RoomDTO("cocina", 5, 5),
                new RoomDTO("baño", 3, 3)
        );
        house.setRooms(rooms);

        // act
        HouseResponseDTO response = service.calculate(house);

        // assertions
        assertEquals("sala", response.getBiggest().getName());
    }

    @Test
    void verifyFeetRoom()
    {
        // assertions
            List<RoomDTO> rooms = List.of(
                    new RoomDTO("sala", 10, 11),
                    new RoomDTO("cocina", 5, 5),
                    new RoomDTO("baño", 3, 3)
            );
            house.setRooms(rooms);

        // act
            HouseResponseDTO response = service.calculate(house);

        // assertions
        assertEquals(response.getRooms().get(0).getSquareFeet(), 110);
        assertEquals(response.getRooms().get(1).getSquareFeet(), 25);
        assertEquals(response.getRooms().get(2).getSquareFeet(), 9);
    }
}
