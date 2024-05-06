package com.mercadolibre.calculadorametroscuadrados.unit.controller;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {
    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    HouseDTO house;
    HouseResponseDTO response;

    @BeforeEach
    void setUp() {
        RoomDTO living = new RoomDTO( "Living room", 8, 6 );
        RoomDTO bathroom = new RoomDTO( "Bathroom", 3, 2 );
        RoomDTO room = new RoomDTO( "Room", 5, 4 );
        RoomDTO kitchen = new RoomDTO( "Kitchen", 4, 3 );
        List<RoomDTO> rooms = List.of(living, bathroom, room, kitchen);
        house = new HouseDTO( "House One", "Falsa 123", rooms );

        response = new HouseResponseDTO();
        response.setRooms(rooms);
        response.setSquareFeet( 86 );
        response.setBiggest(living);
        response.setPrice( 86 * 800);
    }


    @Test
    void calculateTest() {
        HouseResponseDTO houseResponse = calculateRestController.calculate( house );

        assertEquals(response.getBiggest().getName(), houseResponse.getBiggest().getName());
    }
}
