package org.meli.ejercicio_p4_d1_seguros_autos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.meli.ejercicio_p4_d1_seguros_autos.modelo.Siniestro;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoDTO {
    private String matricula;
    private String patente;
    private String marca;
    private String modelo;
    @JsonProperty("agnoFabricacion")
    private Integer agno_fabricacion;
    @JsonProperty("numRuedas")
    private Integer numRuedas;
    private Set<SiniestroDTO> siniestros;
}
