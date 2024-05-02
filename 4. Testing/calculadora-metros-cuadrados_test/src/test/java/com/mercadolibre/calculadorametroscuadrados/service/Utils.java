package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static HouseDTO getRandomHouse(Integer roomCount) {
        HouseDTO newHouse = new HouseDTO();
        newHouse.setName("Test House");
        newHouse.setAddress("Test Address");
        List<RoomDTO> roomDTOList = new ArrayList<>();
        for (int i = 0; i < roomCount; i++){
            roomDTOList.add(getTestRoom());
        }
        roomDTOList.add(getBiggestTestRoom());
        newHouse.setRooms(roomDTOList);
        return newHouse;
    }

    public static RoomDTO getTestRoom() {
        RoomDTO newRoom = new RoomDTO();
        newRoom.setWidth(11);
        newRoom.setLength(7);
        newRoom.setName("Test Room");
        return newRoom;
    }

    public static RoomDTO getBiggestTestRoom() {
        RoomDTO newRoom = new RoomDTO();
        newRoom.setWidth(20);
        newRoom.setLength(50);
        newRoom.setName("Test Biggest Room");
        return newRoom;
    }
}
