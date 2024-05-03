package utils;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public static final Integer squareFeetPrice = 800;

    public static Integer calculateSquareFeet(RoomDTO room) {
        return room.getWidth() * room.getLength();
    }

    public static Integer calculateTotalSquareFeet(List<RoomDTO> rooms) {
        return rooms.stream().mapToInt(TestUtils::calculateSquareFeet).sum();
    }

    public static List<RoomDTO> roomsBuilder(int numberOfRooms) {
        List<RoomDTO> rooms = new ArrayList<>();

        for (int i = 0; i < numberOfRooms; i++) {
            String roomName = "Room_" + i;

            if (i == numberOfRooms - 1) {
                roomName += "_biggest";
            }

            rooms.add(RoomDTO.builder()
                            .name(roomName)
                            .width(i * 3)
                            .length(i * 6)
                    .build());
        }

        return rooms;
    }


    public static HouseDTO createHouseDTO(List<RoomDTO> rooms) {
        return HouseDTO.builder()
                .name("Casa")
                .address("Caseros 3039")
                .rooms(rooms)
                .build();
    }
}
