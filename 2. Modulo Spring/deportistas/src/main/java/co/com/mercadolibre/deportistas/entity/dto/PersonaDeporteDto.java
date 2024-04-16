package co.com.mercadolibre.deportistas.entity.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PersonaDeporteDto {
    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
