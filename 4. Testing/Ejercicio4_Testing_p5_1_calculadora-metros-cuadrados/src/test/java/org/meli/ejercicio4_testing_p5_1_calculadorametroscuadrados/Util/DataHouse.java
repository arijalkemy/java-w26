package org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.Util;

import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.dto.HouseDTO;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.dto.HouseResponseDTO;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class DataHouse {

    public static HouseDTO getHouseDto(){
        // Creamos una instancia de HouseDTO y llenamos sus campos
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("Casa campestre");
        houseDTO.setAddress("Calle 52 b sur # 11-39 norte");

        // Creamos una lista de habitaciones
        List<RoomDTO> rooms = new ArrayList<>();

        // Creamos las instancias de RoomDTO y las añadimos a la lista
        RoomDTO room1 = new RoomDTO();
        room1.setName("Habitación 001");
        room1.setWidth(5);
        room1.setLength(6);
        rooms.add(room1);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Habitación 002");
        room2.setWidth(4);
        room2.setLength(7);
        rooms.add(room2);

        RoomDTO room3 = new RoomDTO();
        room3.setName("Habitación 003");
        room3.setWidth(6);
        room3.setLength(8);
        rooms.add(room3);

        // Establecemos la lista de habitaciones en HouseDTO
        houseDTO.setRooms(rooms);

        return houseDTO;
    }

    public static HouseResponseDTO getHouseResponseDTO(HouseDTO houseDTO){
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(houseDTO);
        houseResponseDTO.setSquareFeet(106);
        houseResponseDTO.setPrice(84800);
        houseResponseDTO.setBiggest(houseDTO.getRooms().get(2));
        return houseResponseDTO;
    }

}
