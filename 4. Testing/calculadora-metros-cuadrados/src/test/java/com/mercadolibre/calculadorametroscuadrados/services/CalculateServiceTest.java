package com.mercadolibre.calculadorametroscuadrados.services;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class CalculateServiceTest {

    private CalculateService calculateService;
    HouseDTO houseDTO;

    @BeforeEach
    public void setup() {
        this.calculateService = new CalculateService();
        this.houseDTO = generateHouseDTO();
    }

    @Test
    @DisplayName("Calcula el valor de la propiedad basado en metros cuadrados")
    public void calcular() {
        HouseResponseDTO houseResponseDTO = calculateService.calculate(this.houseDTO);
        Assertions.assertEquals(2320000, houseResponseDTO.getPrice());
    }

    @Test
    @DisplayName("Verifica que la habitacion con mayores dimensiones es la más grande")
    public void verifyBiggestRoom() {
        HouseResponseDTO houseResponseDTO = calculateService.calculate(this.houseDTO);
        RoomDTO roomDTO =   new RoomDTO("cuarto dos", 40, 40);
        Assertions.assertEquals(roomDTO.getWidth()* roomDTO.getLength()
                , houseResponseDTO.getBiggest().getWidth()*houseResponseDTO.getBiggest().getLength());
    }
    @Test
    @DisplayName("Verifica cantidad correcta de metros cuadrados por habitacion")
    public void calculateSquarefeedByRoom() {
        HouseResponseDTO houseResponseDTO = calculateService.calculate(this.houseDTO);
        RoomDTO roomDTO =   new RoomDTO("cuarto dos", 40, 40);
        Assertions.assertEquals(40*40,roomDTO.getSquareFeet());
    }

    private HouseDTO generateHouseDTO() {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("1");
        houseDTO.setAddress("calle false");
        houseDTO.setRooms(List.of(
                new RoomDTO("cuarto uno", 30, 30),
                new RoomDTO("cuarto dos", 40, 40),
                new RoomDTO("cuarto tres", 20, 20)
        ));
        return houseDTO;
    }
}
