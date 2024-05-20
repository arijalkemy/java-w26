package com.bootcamp.joyeria.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JewelUpdateDTO {
    @JsonProperty("nro_identificatorio")
    private Long id;
    @JsonProperty("nombre")
    private String name;
    private String material;
    @JsonProperty("peso")
    private Double weight;
    @JsonProperty("particularidad")
    private String particularity;
    @JsonProperty("posee_piedra")
    private boolean hasStone;
    @JsonProperty("ventaONo")
    private boolean sellOrNot;
}
