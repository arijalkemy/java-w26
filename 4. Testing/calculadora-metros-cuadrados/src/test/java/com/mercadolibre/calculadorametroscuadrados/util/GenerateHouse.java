package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class GenerateHouse {
    public static HouseDTO generateHouse() {
        return new HouseDTO("House 1", "Street 1", generateRooms());
    }

    public static List<RoomDTO> generateRooms() {
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(new RoomDTO("Bathroom", 2, 3));
        rooms.add(new RoomDTO("Dining room", 5, 5));
        rooms.add(new RoomDTO("Living room", 4, 8));
        return rooms;
    }

    public static HouseDTO generateHouseWithoutRooms() {
        return new HouseDTO("House 1", "Street 1", new ArrayList<>());
    }
}
