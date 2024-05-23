package org.example.libreria.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "obraliteraria_")
public class ObraLiteraria {
    @Id
    private String id;

    private String nombre;

    private String autor;

    private Integer cantidad_paginas;

    private String editorial;

    private  Integer anio_publicacion;
}
