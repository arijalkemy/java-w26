package com.mercadolibre.Obras_Literarias.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiterariaResponseDto {
    String id;
    String nombre;
    String autor;
    Integer cantidadPaginas;
    String editorial;
    Integer anioPublicacion;
}
