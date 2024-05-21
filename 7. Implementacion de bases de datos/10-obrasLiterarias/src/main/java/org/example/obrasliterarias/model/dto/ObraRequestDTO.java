package org.example.obrasliterarias.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObraRequestDTO {
    private String nombre;
    private String autor;
    @JsonProperty("cantidad_paginas")
    private Integer paginas;
    private String editorial;
    @JsonProperty("anio_publicacion")
    private Integer anioPublicacion;
}
