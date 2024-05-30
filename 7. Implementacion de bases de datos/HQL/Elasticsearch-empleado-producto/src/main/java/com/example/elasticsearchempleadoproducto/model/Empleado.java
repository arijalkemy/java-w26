package com.example.elasticsearchempleadoproducto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "empleados")
public class Empleado {
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String provincia;
}
