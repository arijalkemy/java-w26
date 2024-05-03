package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
public class HouseDTO {
    private String name;
    private String address;
    private List<RoomDTO> rooms;
}
