package org.meli.ejercicio_p4_d1_seguros_autos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroDtoRequest {
        private Long id_siniestro;
        private LocalDate fecha_siniestro;
        private Double perdida_economica;
}
