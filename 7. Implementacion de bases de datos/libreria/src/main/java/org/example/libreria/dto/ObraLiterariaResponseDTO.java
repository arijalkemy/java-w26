package org.example.libreria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObraLiterariaResponseDTO{
        private String id;
        private String nombre;
        private String autor;
        @JsonProperty("cantidadPaginas")
        private Long cantidad_paginas;
        private String editorial;
        @JsonProperty("anioPublicacion")
        private Long anio_publicacion;
}
