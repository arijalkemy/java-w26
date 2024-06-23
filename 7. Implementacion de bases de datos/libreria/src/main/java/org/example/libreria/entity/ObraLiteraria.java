package org.example.libreria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "obraliteraria_")
public class ObraLiteraria {
    @Id
    private String id;
    @Field(name = "nombre", type = FieldType.Text)
    private String nombre;
    @Field(name = "autor", type = FieldType.Text)
    private String autor;
    @Field(name = "cantidad_paginas", type = FieldType.Long)
    private Long cantidadPaginas;
    @Field(name = "editorial", type = FieldType.Text)
    private String editorial;
    @Field(name = "anio_publicacion", type = FieldType.Long)
    private Long anioPublicacion;
}
