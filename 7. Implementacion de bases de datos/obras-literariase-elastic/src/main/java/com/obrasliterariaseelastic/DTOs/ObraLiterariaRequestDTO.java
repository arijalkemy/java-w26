package com.obrasliterariaseelastic.DTOs;

import lombok.Data;

@Data
public class ObraLiterariaRequestDTO {
    private String name;
    private String autor;
    private Integer cantPaginas;
    private String editorial;
    private Integer anioPublicacion;
}
