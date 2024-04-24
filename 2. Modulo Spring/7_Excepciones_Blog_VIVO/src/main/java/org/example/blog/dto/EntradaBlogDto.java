package org.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EntradaBlogDto {
    private int id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
}
