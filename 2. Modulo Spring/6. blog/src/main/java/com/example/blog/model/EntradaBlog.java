package com.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {

    private Integer id;
    private String titulo;
    private String nombreAutor;
    private String fechaDePublicacion;
}
