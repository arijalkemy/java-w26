package org.example.empleadoselastic.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Getter
@Setter
@Data
@Document(indexName = "empleado")
public class Empleado {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private Long edad;
    private String ciudad;
    private String departamento;
}
