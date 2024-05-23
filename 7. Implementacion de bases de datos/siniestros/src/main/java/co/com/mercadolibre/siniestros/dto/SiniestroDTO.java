package co.com.mercadolibre.siniestros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroDTO {

    private Long id;
    private String fechaDeSiniestro;
    private Integer perdidaEconomica;
    private VehiculoDTO vehiculo;
}
