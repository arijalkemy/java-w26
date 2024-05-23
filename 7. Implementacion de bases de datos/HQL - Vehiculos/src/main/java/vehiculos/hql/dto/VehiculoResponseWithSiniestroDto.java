package vehiculos.hql.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehiculoResponseWithSiniestroDto {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anoFabricacion;
    private Integer cantidadRuedas;

    private Set<SiniestroRequestDto> siniestros;
}
