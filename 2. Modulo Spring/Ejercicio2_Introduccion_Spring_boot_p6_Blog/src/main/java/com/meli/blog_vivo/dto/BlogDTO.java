package com.meli.blog_vivo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor @Getter @Setter
public class BlogDTO {
    private Integer id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
}
