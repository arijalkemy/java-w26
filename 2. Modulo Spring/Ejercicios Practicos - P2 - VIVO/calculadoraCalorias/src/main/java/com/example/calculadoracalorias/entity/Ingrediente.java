package com.example.calculadoracalorias.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("calories")
    private Integer calorias;

}
