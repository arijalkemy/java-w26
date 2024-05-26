package com.example.ejercicio_implementacion_nosql_empleados.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "empleados")
public class Empleado {
    @Id
    private Long id;
    @Field(type = FieldType.Text)
    private String nombre;
    @Field(type = FieldType.Text)
    private String apellido;
    @Field(type = FieldType.Integer)
    private Integer edad;
    @Field(type = FieldType.Text)
    private String ciudad;
    @Field(type = FieldType.Text)
    private String localidad;
}
