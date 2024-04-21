package deportistas.deportistas.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    String nombre;
    String apellido;
    int edad;
    Integer idSport;
}
