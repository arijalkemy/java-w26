package com.meli.obras_literarias_VIVO.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseObraDto {
    String id;
    String nombre;
    String autor;
    Integer cantidadDePaginas;
    String editorial;
    Integer año;
}
