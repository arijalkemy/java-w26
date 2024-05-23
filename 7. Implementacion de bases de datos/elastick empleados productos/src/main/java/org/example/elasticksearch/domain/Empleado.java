package org.example.elasticksearch.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Data
@Document(indexName = "empleados")
public class Empleado{
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String nombre;

    @Field(type = FieldType.Text)
    private String apellido;

    @Field(type = FieldType.Integer)
    private int edad;

    @Field(type = FieldType.Text)
    private String ciudad;

    @Field(type = FieldType.Text)
    private String provincia;
}
