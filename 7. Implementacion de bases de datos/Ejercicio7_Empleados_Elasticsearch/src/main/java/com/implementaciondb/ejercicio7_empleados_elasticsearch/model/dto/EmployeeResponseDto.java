package com.implementaciondb.ejercicio7_empleados_elasticsearch.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("edad")
    private Integer edad;

    @JsonProperty("ciudad")
    private String ciudad;

    @JsonProperty("provincia")
    private String provincia;
}
