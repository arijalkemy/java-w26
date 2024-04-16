package bootcamp.spring.covid.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {

     private int id;
     private int edad;
     private String nombre;
     private String apellido;
}
