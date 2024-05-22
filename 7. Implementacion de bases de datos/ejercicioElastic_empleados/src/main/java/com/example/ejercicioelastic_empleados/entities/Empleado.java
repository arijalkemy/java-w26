package com.example.ejercicioelastic_empleados.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "empleado")
@Data
@Builder
public class Empleado {
    @Id
    private String id;

    @Field(type = FieldType.Annotated_Text)
    private String nombre;
    @Field(type = FieldType.Annotated_Text)
    private String apellido;
    @Field(type = FieldType.Integer)
    private int edad;
    @Field(type = FieldType.Annotated_Text)
    private String ciudad;
    @Field(type = FieldType.Annotated_Text)
    private String provincia;
}
