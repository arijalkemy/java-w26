package org.example.es_hib_empleados.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@Document(indexName = "employee")
public class Empleado {
    @Id
    private String id;
    @Field(name = "name")
    private String nombre;
    @Field(name = "lastname")
    private String apellido;
    @Field(name = "age")
    private int edad;
    @Field(name = "city")
    private String ciudad;
    @Field(name = "state")
    private String estado;
}
