package com.meli.Obras.literarias.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObraDto {
    private String nombre;
    private String autor;
    private Integer cantidadDePaginas;
    private String editorial;
    private String fechaPublicacion;
}
