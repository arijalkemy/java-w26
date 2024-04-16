package bootcamp.spring.deportistas.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Deporte {
    String nombre;
    String nivel;
}