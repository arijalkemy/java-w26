package com.mercadolibre.calculadorametroscuadrados.utils;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.List;

public final class TestUtils {
    private static final List<RoomDTO> rooms = List.of(makeRoomDTO(1),
                                                        makeRoomDTO(2),
                                                        makeRoomDTO(3),
                                                        makeRoomDTO(4));

    public static HouseDTO makeHouseDTO(){
        return new HouseDTO().builder()
                .name("Casita")
                .address("Calle Falsa 123")
                .rooms(rooms)
                .build();
    }


    public static HouseResponseDTO makeHouseResponseDTO(){
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(makeHouseDTO());
        houseResponseDTO.setSquareFeet(48);
        houseResponseDTO.setPrice(38400);
        houseResponseDTO.setBiggest(rooms.get(3));
        return houseResponseDTO;
    }

    private static RoomDTO makeRoomDTO(Integer i){
        switch (i){
            case 1:
                return new RoomDTO().builder().name("Cocina").width(3).length(3).build();
            case 2:
                return new RoomDTO().builder().name("Cuarto").width(2).length(4).build();
            case 3:
                return new RoomDTO().builder().name("Baño").width(2).length(3).build();
            default:
                return new RoomDTO().builder().name("Living").width(5).length(5).build();
        }
    }
}
