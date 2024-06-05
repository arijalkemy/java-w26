package com.meli.blog_vivo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor @Setter @Getter
public class Blog {
    private Integer id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
}
