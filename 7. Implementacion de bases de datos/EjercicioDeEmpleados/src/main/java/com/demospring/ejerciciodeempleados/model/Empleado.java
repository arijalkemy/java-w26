package com.demospring.ejerciciodeempleados.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "empleados")
@AllArgsConstructor
@NoArgsConstructor
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
