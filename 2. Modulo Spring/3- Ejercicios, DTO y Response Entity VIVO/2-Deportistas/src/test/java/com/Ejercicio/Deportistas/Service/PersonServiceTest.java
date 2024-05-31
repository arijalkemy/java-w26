package com.Ejercicio.Deportistas.Service;

import com.Ejercicio.Deportistas.DTO.PersonDTO;
import com.Ejercicio.Deportistas.Entity.Person;
import com.Ejercicio.Deportistas.Entity.Sport;
import com.Ejercicio.Deportistas.Repository.IPersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private IPersonRepository personRepository;

    @Autowired
    private IPersonService personService;

    private ModelMapper modelMapper = new ModelMapper();

    private static List<Person> persons;
    @BeforeEach
    public void setup() {
        persons = new ArrayList<>();
        persons.add(new Person("Juan", "García", 30, new Sport("Fútbol", "Profesional")));
        persons.add(new Person("María", "Martínez", 25, new Sport("Baloncesto", "Amateur")));
        persons.add(new Person("Pedro", "López", 35, new Sport("Tenis", "Profesional")));
        persons.add(new Person("Ana", "Sánchez", 28, new Sport("Natación", "Recreativo")));
        persons.add(new Person("Luis", "Rodríguez", 32, new Sport("Atletismo", "Profesional")));
    }

    @Test
    @DisplayName("Create a test list equals to persons list on repository and expected personService return same list mapped to Dto")
    public void findAllPersonTest() {
        //Arrange
        List <PersonDTO> expectedDtoList = persons.stream().map(person -> modelMapper.map(person, PersonDTO.class)).collect(Collectors.toList());

        //Act
        List<PersonDTO> personDTOList = personService.findAllPerson();

        //Assert
        assertEquals(expectedDtoList, personDTOList);
    }
}
