package meli.bootcamp.hql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroResDto {
    Long id;
    private LocalDate fecha;
    private VehiculoResDto vehiculoDenunciado;

    @JsonProperty("perdida_economica")
    private Double perdidaEconomica;
}