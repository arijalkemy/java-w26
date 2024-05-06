package com.mercadolibre.calculadorametroscuadrados.unit.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {
    HouseDTO house;

    CalculateService calculateService;

    int square;

    @BeforeEach
    void setUp() {
        calculateService = new CalculateService();

        square = 86;

        RoomDTO living = new RoomDTO( "Living room", 8, 6 );
        RoomDTO bathroom = new RoomDTO( "Bathroom", 3, 2 );
        RoomDTO room = new RoomDTO( "Room", 5, 4 );
        RoomDTO kitchen = new RoomDTO( "Kitchen", 4, 3 );

        house = new HouseDTO( "House One", "Falsa 123", List.of(living, bathroom, room, kitchen) );

    }

    @Test
    void biggestRoomTest() {

        HouseResponseDTO responseHouse = calculateService.calculate(house);

        RoomDTO living = new RoomDTO( "Living room", 8, 6 );

        assertEquals(living.getName() , responseHouse.getBiggest().getName());

    }

    @Test
    void squareFeetTest() {

        HouseResponseDTO responseHouse = calculateService.calculate(house);

        assertEquals(square , responseHouse.getSquareFeet());

    }

    @Test
    void priceTest() {

        int price = square * 800;

        HouseResponseDTO responseHouse = calculateService.calculate(house);

        assertEquals(price , responseHouse.getPrice());

    }

    @Test
    void squareFeetWithNullLenghtTest() {

        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add( new RoomDTO("NullRoom", 2, 0) );
        rooms.add( new RoomDTO("room", 2, 2) );

        house.setRooms( rooms );

        HouseResponseDTO responseHouse = calculateService.calculate(house);

        assertEquals(4 , responseHouse.getSquareFeet());

    }

    @Test
    void squareFeetWithNullWidthTest() {

        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add( new RoomDTO("NullRoom", null, 2) );
        rooms.add( new RoomDTO("room", 2, 2) );

        house.setRooms( rooms );

        HouseResponseDTO responseHouse = calculateService.calculate(house);

        assertEquals(4 , responseHouse.getSquareFeet());

    }
}
