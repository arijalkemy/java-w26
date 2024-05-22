package vehiculos.hql.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehiculoResponseDto {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anoFabricacion;
    private Integer cantidadRuedas;
}
