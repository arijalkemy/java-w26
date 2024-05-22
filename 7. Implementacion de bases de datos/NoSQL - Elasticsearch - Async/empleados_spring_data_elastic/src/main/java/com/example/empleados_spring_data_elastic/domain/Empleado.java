package com.example.empleados_spring_data_elastic.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.nio.entity.NStringEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Document(indexName = "empresa")
@Getter
@Setter
public class Empleado {

    @Id
    private String id;

    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String estado;


}
