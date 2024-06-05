package org.meli.ejercicio_p4_d1_seguros_autos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoDtoRequest {
    private String matricula;
    private String patente;
    private String marca;
    private String modelo;
    private Integer agno_fabricacion;
    private Integer num_ruedas;
    private Set<SiniestroDtoRequest> siniestros;
}