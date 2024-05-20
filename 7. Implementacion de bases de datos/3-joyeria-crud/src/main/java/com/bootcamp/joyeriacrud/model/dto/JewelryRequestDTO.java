package com.bootcamp.joyeriacrud.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JewelryRequestDTO implements Serializable {
    @JsonProperty("nombre")
    private String name;

    @JsonProperty("material")
    private String material;

    @JsonProperty("peso")
    private double weight;

    @JsonProperty("particularidad")
    private String peculiarity;

    @JsonProperty("posee_piedra")
    private boolean hasStone;
}
