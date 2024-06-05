package org.meli.ejercicio_p4_d1_seguros_autos.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.meli.ejercicio_p4_d1_seguros_autos.modelo.Vehiculo;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroDTO {
    @JsonProperty
    private Long id_siniestro;
    private LocalDate fecha_siniestro;
    private Double perdida_economica;
}
