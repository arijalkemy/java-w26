package com.mercadolibre.calculadorametroscuadrados;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.List;

public class TestUtilsGenerator {
    public static HouseDTO generateHouseDTORequest(){
        return new HouseDTO(
                "Kame-house",
                "Island of the South",
                List.of(
                        new RoomDTO("living room", 8, 6),
                        new RoomDTO("kitchen", 3, 6),
                        new RoomDTO("bedroom", 2, 4)
                )
        );
    }

    public static HouseResponseDTO generateHouseResponseDTO(HouseDTO house){
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(house);
        houseResponseDTO.setBiggest(new RoomDTO("living room", 8, 6));
        houseResponseDTO.setSquareFeet(72);
        houseResponseDTO.setPrice(59200);
        return houseResponseDTO;
    }
}
