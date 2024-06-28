package com.example.obrasliterarias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.lang.reflect.Type;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Document(indexName = "libros_")
public class Libro {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private Integer cantidadDePaginas;
    private String editorial;
    @Field(type = FieldType.Date, format = DateFormat.basic_date)
    private LocalDate fechaPublicacion;
}
