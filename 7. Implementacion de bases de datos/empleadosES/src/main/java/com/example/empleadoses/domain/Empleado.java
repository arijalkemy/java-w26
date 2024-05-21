package com.example.empleadoses.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "empleados")
@Data
public class Empleado {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudad;
    private String provincia;

}
