package com.mercadolibre.joyerialasperlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class JewelDTO implements Serializable {
    private String name;
    private String material;
    private Integer weight;
    private String quirk;
    @JsonProperty("has_stone")
    private Boolean hasStone;
    private Boolean sellOrNot;
}
