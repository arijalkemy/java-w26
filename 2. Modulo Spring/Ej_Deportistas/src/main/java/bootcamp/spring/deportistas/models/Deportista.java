package bootcamp.spring.deportistas.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Deportista {
    private String nombre;
    private String apellido;
    private Integer edad;
}
