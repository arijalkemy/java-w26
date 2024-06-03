package com.meli.obrasliterarias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCreateObraDTO {
    private String id;
    private String nombre;
    private String nombreDeAutor;
    private Integer cantidadDePaginas;
    private String editorial;
//    @Field(type = FieldType.Date, format = DateFormat.basic_date)
    private Integer anio;
}
