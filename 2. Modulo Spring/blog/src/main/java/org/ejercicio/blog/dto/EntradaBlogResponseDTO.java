package org.ejercicio.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class EntradaBlogResponseDTO {
    private int id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
}
