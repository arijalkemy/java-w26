package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RoomDTO {
    private String name;
    private Integer width;
    private Integer length;

    public Integer getSquareFeet() {
        Integer result = 0;
        if (this.width != null && this.length != null)
            result = this.width * this.length;
        return result;
    }
}
