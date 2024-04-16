package bootcamp.spring.covid.dtos;

import java.io.Serializable;

import bootcamp.spring.covid.models.Persona;
import lombok.Data;

@Data
public class PersonaDTO implements Serializable {
    String nombreCompleto;

    public PersonaDTO(Persona persona){
        this.nombreCompleto = String.format("%s %s", persona.getNombre(),persona.getApellido());
    }
}
