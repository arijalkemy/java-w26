package com.example.sinisestros.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class VehiculoDTO {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int cantidadRuedas;
}
