package com.mercadolibre.calculadorametroscuadrados.utils;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static HouseDTO createHouseDTO() {
        List<RoomDTO> roomDTOList = createRooms();

        return new HouseDTO(
                "Casa",
                "Calle 123",
                roomDTOList
        );
    }

    public static HouseResponseDTO createHouseResponseDTO() {
        return new HouseResponseDTO(
                22,
                17600,
                new RoomDTO(
                    "Comedor",
                    4,
                    4
                ),
                "Casa",
                "Calle 123",
                createRooms()
        );
    }

    public static List<RoomDTO> createRooms() {
        List<RoomDTO> roomDTOList = new ArrayList<RoomDTO>();
        roomDTOList.add(
                new RoomDTO(
                        "Baño",
                        2,
                        3
                )
        );
        roomDTOList.add(
                new RoomDTO(
                        "Comedor",
                        4,
                        4
                )
        );

        return roomDTOList;
    }
}
