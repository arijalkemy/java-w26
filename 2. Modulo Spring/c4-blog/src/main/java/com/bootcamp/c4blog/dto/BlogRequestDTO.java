package com.bootcamp.c4blog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogRequestDTO {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
