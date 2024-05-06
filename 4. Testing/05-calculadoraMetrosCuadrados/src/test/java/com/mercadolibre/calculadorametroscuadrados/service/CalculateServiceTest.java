package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    CalculateService service;

    HouseDTO houseDTO;

    @BeforeEach
    void setUp() {
        service = new CalculateService();
        houseDTO = new HouseDTO("Duplex", "Holmberg 1100",
                List.of(new RoomDTO("Habitacion", 4, 4),
                        new RoomDTO("Living", 6, 5),
                        new RoomDTO("Cocina", 3, 5)));
    }

    @Test
    void calculateSquareFeetOk() {
        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setSquareFeet(61);

        HouseResponseDTO actual = service.calculate(houseDTO);

        assertEquals(expected.getSquareFeet(), actual.getSquareFeet());

    }

    @Test
    void calculateFail() {
        houseDTO.setRooms(null);

        assertThrows(NullPointerException.class, () -> service.calculate(houseDTO));
    }

    @Test
    void calculatePriceOk() {
        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setPrice(61 * 800);

        HouseResponseDTO actual = service.calculate(houseDTO);

        assertEquals(expected.getPrice(), actual.getPrice());
    }

    @Test
    void calculateRoomOk() {
        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setBiggest(houseDTO.getRooms().get(1));

        HouseResponseDTO actual = service.calculate(houseDTO);

        assertEquals(expected.getBiggest(), actual.getBiggest());
    }


}