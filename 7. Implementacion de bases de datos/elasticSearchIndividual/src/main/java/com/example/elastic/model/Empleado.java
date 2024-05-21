package com.example.elastic.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "empleado")
@Getter
@Setter
public class Empleado {
    //id, nombre, apellido, edad, ciudad y provincia/estado/departamento
    @Id
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudad;
    private String provincia;
}
