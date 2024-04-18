package ejercicioDeportista.ejercicioDeportista.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
