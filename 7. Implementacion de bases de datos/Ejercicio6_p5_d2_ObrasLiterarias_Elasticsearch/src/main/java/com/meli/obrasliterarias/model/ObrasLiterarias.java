package com.meli.obrasliterarias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDate;

@Document(indexName = "obras_literarias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObrasLiterarias {
    @Id
    private String id;
    private String nombre;
    private String nombreDeAutor;
    private Integer cantidadDePaginas;
    private String editorial;
//    @Field(type = FieldType.Date, format = DateFormat.year)
    private Integer anio;
}
