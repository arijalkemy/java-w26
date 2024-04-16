package co.com.mercadolibre.deportistas.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Persona {

    private String nombre;
    private String apellido;
    private Integer edad;
    private Deporte deporte;
}
