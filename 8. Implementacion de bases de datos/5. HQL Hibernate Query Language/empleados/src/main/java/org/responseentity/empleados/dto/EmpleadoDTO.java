package org.responseentity.empleados.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.responseentity.empleados.domain.Direccion;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpleadoDTO {
    private String id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;

    @JsonProperty("direccion")
    private Direccion direccion;
}
