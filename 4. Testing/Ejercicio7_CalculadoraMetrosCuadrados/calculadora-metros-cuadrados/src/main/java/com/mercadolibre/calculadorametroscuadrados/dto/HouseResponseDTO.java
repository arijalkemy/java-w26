package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class HouseResponseDTO extends HouseDTO {
    private Integer squareFeet;
    private Integer price;
    private RoomDTO biggest;

    public HouseResponseDTO(HouseDTO house) {
        this.setName(house.getName());
        this.setAddress(house.getAddress());
        this.setRooms(house.getRooms());
    }
}
