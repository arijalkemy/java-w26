package org.example.libreria.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ObraLiterariaRequestDTO {

        private String nombre;

        private String autor;

        private Integer cantidad_paginas;

        private String editorial;

        private  Integer anio_publicacion;

}
