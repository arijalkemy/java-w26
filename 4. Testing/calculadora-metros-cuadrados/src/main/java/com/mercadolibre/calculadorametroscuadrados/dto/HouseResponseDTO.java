package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
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
