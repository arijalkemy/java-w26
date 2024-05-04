package com.mercadolibre.calculadorametroscuadrados.Unitary;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculatePriceTest {

    CalculateService calculateService;
    @BeforeEach
    public void setup() {
         calculateService = new CalculateService();
    }


    @Test
    public void testCalculatePrice() {

        // Crear una lista de RoomDTO
        List<RoomDTO> rooms = new ArrayList<>();
        // Crear un objeto RoomDTO
        rooms.add(new RoomDTO()); // Añade un RoomDTO vacío, puedes personalizarlo según tus necesidades

        // Crear un objeto HouseDTO
        HouseDTO house = new HouseDTO();
        house.setName("Casa Ejemplo"); // Establecer el nombre de la casa
        house.setAddress("Dirección Ejemplo"); // Establecer la dirección de la casa
        house.setRooms(rooms); // Establecer las habitaciones de la casa


        // Crear un objeto CalculatePrice


        HouseResponseDTO houseResponseDTO =  calculateService.calculate(house);


        // Verificar que el precio calculado sea el esperado
        assertEquals(0, houseResponseDTO.getPrice());

    }

    @Test
    public void roomBiggerestTest() {

        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO room = new RoomDTO();
        room.setName("Habitación Ejemplo"); // Establecer el nombre de la habitación
        room.setWidth(10); // Establecer el ancho de la habitación
        room.setLength(20); // Establecer la longitud de la habitación
        rooms.add(room); // Añadir la habitación a la lista de habitaciones
        RoomDTO room2 = new RoomDTO();
        room2.setName("Habitación Ejemplo 2"); // Establecer el nombre de la habitación
        room2.setWidth(5); // Establecer el ancho de la habitación
        room2.setLength(10); // Establecer la longitud de la habitación
        rooms.add(room2);


        HouseDTO house = new HouseDTO();
        house.setName("Casa Ejemplo"); // Establecer el nombre de la casa
        house.setAddress("Dirección Ejemplo"); // Establecer la dirección de la casa
        house.setRooms(rooms); // Establecer las habitaciones de la casa

        HouseResponseDTO houseResponseDTO = calculateService.calculate(house);
        assertEquals(houseResponseDTO.getBiggest(),room);

    }


    @Test
    public void getSizeToRoom()
    {
        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO room = new RoomDTO();
        room.setName("Habitación Ejemplo"); // Establecer el nombre de la habitación
        room.setWidth(10); // Establecer el ancho de la habitación
        room.setLength(20); // Establecer la longitud de la habitación
        rooms.add(room); // Añadir la habitación a la lista de habitaciones
        RoomDTO room2 = new RoomDTO();
        room2.setName("Habitación Ejemplo 2"); // Establecer el nombre de la habitación
        room2.setWidth(5); // Establecer el ancho de la habitación
        room2.setLength(10); // Establecer la longitud de la habitación
        rooms.add(room2);

        HouseDTO house = new HouseDTO();
        house.setName("Casa Ejemplo"); // Establecer el nombre de la casa
        house.setAddress("Dirección Ejemplo"); // Establecer la dirección de la casa
        house.setRooms(rooms); // Establecer las habitaciones de la casa

        HouseResponseDTO houseResponseDTO = calculateService.calculate(house);

        assertEquals(houseResponseDTO.getRooms().get(0).getSquareFeet() , room.getSquareFeet());
        assertEquals(houseResponseDTO.getRooms().get(1).getSquareFeet() , room2.getSquareFeet());
    }



}
