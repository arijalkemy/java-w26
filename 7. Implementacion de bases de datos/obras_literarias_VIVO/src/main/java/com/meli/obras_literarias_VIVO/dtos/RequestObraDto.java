package com.meli.obras_literarias_VIVO.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class RequestObraDto {
    String nombre;
    String autor;
    Integer cantidadDePaginas;
    String editorial;
    Integer año;
}
