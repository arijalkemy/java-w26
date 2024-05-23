package vehiculos.hql.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SiniestroRequestDto {
    private Long vehiculo_id;
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;

}
