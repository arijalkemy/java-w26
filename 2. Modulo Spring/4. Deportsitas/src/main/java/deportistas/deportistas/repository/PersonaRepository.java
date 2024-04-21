package deportistas.deportistas.repository;

import deportistas.deportistas.DTO.PersonDTO;
import deportistas.deportistas.Entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaRepository {
    private static final List<Person> persons = List.of(new Person[]{
            new Person("Juan", "Pérez", 25, 1),
            new Person("María", "González", 45, 2),
            new Person("Jose", "González", 40, 2),
            new Person("Roberto", "González", 20, 2),
            new Person("Diego", "González", 70, 0)
    });


    public static List<PersonDTO> getSportsPerson() {

        List<PersonDTO>  personDTOS= persons
                .stream()
                .filter(person -> person.getIdSport() != 0)
                .map(person -> new PersonDTO(person)).toList();

        System.out.println(personDTOS);
        return personDTOS;
    }
}
