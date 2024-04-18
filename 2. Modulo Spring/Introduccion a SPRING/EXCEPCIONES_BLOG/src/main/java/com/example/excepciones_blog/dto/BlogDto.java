package com.example.excepciones_blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    private UUID id;
    private String tituloBlog;
    private String nombreAutor;
    private String fechaPublicacion;
}
