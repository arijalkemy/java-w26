package com.mercadolibre.calculadorametroscuadrados.controller;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CalculateRestControllerTest {

    CalculateRestController controller;

    HouseDTO houseDTO;

    @BeforeEach
    void setUp() {
        controller = new CalculateRestController();
        houseDTO = new HouseDTO("Duplex", "Holmberg 1100",
                List.of(new RoomDTO("Habitacion", 4, 4),
                        new RoomDTO("Living", 6, 5),
                        new RoomDTO("Cocina", 3, 5)));
    }

    @Test
    void calculateOk() {
        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setSquareFeet(61);
        expected.setPrice(61 * 800);
        expected.setBiggest(houseDTO.getRooms().get(1));

        HouseResponseDTO actual = controller.calculate(houseDTO);

        assertEquals(expected, actual);

    }

    @Test
    void calculateWithNullRoomsFail() {
        houseDTO.setRooms(null);

        assertThrows(NullPointerException.class, () -> controller.calculate(houseDTO));
    }

}