package co.com.mercadolibre.covid.dto;

import co.com.mercadolibre.covid.entity.Sintoma;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonaConRiesgoDto {
    private String nombre;
    private String apellido;
    private List<Sintoma> sintomas;
    private Integer edad;
}
