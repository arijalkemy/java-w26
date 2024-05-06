package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


public class CalculateServiceTest {

    CalculateService calculateService;
    @BeforeEach
    void setup() {
        calculateService = new CalculateService();
    }

    @Test
    public void calculateTest() {
        // arrange
        RoomDTO room = new RoomDTO();
        room.setName("Habitacion");
        room.setWidth(10);
        room.setLength(10);

        HouseDTO request = new HouseDTO();
        request.setRooms(List.of(room));

        HouseResponseDTO expected = new HouseResponseDTO(request);
        expected.setSquareFeet(100);
        expected.setPrice(80000);
        expected.setBiggest(room);

        // act
        HouseResponseDTO obtained = calculateService.calculate(request);

        // assert

        Assertions.assertEquals(expected.getSquareFeet(), obtained.getSquareFeet());
    }

}
