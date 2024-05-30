package com.mercadolibre.Empleados_NOSQL.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "empleados")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Empleado {
    @Id
    String id;
    String nombre;
    String apellido;
    Integer edad;
    String ciudad;
    String departamento;
}
