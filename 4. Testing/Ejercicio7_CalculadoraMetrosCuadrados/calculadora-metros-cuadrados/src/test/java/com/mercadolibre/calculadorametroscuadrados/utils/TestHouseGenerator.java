package com.mercadolibre.calculadorametroscuadrados.utils;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class TestHouseGenerator {

    public static HouseDTO getHouseDTOWithRooms() {
        List<RoomDTO> rooms = new ArrayList<>(List.of(
                new RoomDTO("Espacio abierto", 5, 5),
                new RoomDTO("Cocina", 3, 3),
                new RoomDTO("Baño", 2, 1)
        ));
        return new HouseDTO("Oficina", "Monroe 800", rooms);
    }

    public static HouseResponseDTO getHouseResponseDTOWithRooms() {
        HouseDTO house = TestHouseGenerator.getHouseDTOWithRooms();
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(house);
        houseResponseDTO.setBiggest(house.getRooms().get(0));
        houseResponseDTO.setSquareFeet(36);
        houseResponseDTO.setPrice(28800);
        return houseResponseDTO;
    }
    public static HouseDTO getHouseDTOWithoutRooms() {
        List<RoomDTO> rooms = new ArrayList<>(List.of());
        return new HouseDTO("Oficina", "Monroe 800", rooms);
    }

    public static HouseResponseDTO getHouseResponseDTOWithoutRooms() {
        HouseDTO house = TestHouseGenerator.getHouseDTOWithoutRooms();
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(house);
        houseResponseDTO.setBiggest(null);
        houseResponseDTO.setSquareFeet(0);
        houseResponseDTO.setPrice(0);
        return houseResponseDTO;
    }

}
