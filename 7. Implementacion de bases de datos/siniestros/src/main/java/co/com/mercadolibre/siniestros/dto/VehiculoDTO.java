package co.com.mercadolibre.siniestros.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehiculoDTO {

    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioDeFabricacion;
    private Integer cantidadDeRuedas;
    private List<SiniestroDTO> siniestros;
}
