package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class TestUtilGenerator {

    public static HouseDTO getHouseWith1Room(String name, String address) {
        RoomDTO room = new RoomDTO();
        room.setName("Recamara principal");
        room.setLength(6);
        room.setWidth(4);
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room);

        HouseDTO house = new HouseDTO();
        house.setName(name);
        house.setAddress(address);
        house.setRooms(rooms);
        return house;
    }

    public static HouseDTO getHouseWith3Rooms(String name, String address) {
        RoomDTO room1 = new RoomDTO();
        RoomDTO room2 = new RoomDTO();
        RoomDTO room3 = new RoomDTO();
        room1.setName("Estudio");
        room1.setLength(3);
        room1.setWidth(2);
        room2.setName("Recamara principal");
        room2.setLength(6);
        room2.setWidth(4);
        room3.setName("Recamara huespedes");
        room3.setLength(4);
        room3.setWidth(3);
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        HouseDTO house = new HouseDTO();
        house.setName(name);
        house.setAddress(address);
        house.setRooms(rooms);
        return house;
    }

    public static RoomDTO calculateBiggestRoom(HouseDTO house) {
        RoomDTO biggest = null;
        Integer maxRoom = 0;
        for (RoomDTO room : house.getRooms()) {
            Integer squareFeet = room.getSquareFeet();
            if (biggest == null || squareFeet > maxRoom){
                biggest = room;
                maxRoom = squareFeet;
            }
        }
        return biggest;
    }
    public static List<RoomDTO> calculateSquareFeetByRoom(HouseDTO house) {
        List<RoomDTO> totalSquareFeet = new ArrayList<>();
        for (RoomDTO room : house.getRooms()) {
            room.getSquareFeet();
            totalSquareFeet.add(room);
        }
        return totalSquareFeet;
    }
    public static int calculatePriceProperty(HouseDTO house) {
        Integer totalSquareFeet = 0;
        for (RoomDTO room : house.getRooms()) {
            Integer squareFeet = room.getSquareFeet();
            totalSquareFeet += squareFeet;
        }
        return totalSquareFeet * 800;
    }
}
