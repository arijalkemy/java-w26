package vehiculos.hql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vehiculos.hql.model.Vehiculo;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroResponseDto {
    private Long id;
    private VehiculoResponseDto vehiculo;
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
}
