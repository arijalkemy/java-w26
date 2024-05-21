package com.meli.Empleados.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "empleado")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Empleado {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudad;
    private String provincia;
    private String estado;
    private String departamento;
}
