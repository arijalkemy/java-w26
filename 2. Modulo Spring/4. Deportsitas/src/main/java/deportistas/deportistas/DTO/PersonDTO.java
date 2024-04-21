package deportistas.deportistas.DTO;

import deportistas.deportistas.Entity.Person;
import deportistas.deportistas.Entity.Sport;
import deportistas.deportistas.repository.SportRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
public class PersonDTO {
    private String nombre;
    private String apellido;
    private Optional<Sport> sport;

    public PersonDTO(Person person){

        this.nombre = person.getNombre();
        this.apellido = person.getApellido();
        this.sport = SportRepository.getSPortById(person.getIdSport());
    }

}
