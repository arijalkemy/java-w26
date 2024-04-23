package com.example.libros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO {

    private int id;
    private String titulo;
    private String autor;
    private String fecha;
}
