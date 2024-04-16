package org.example.dtosport;

import org.example.dtosport.entity.Person;
import org.example.dtosport.entity.Sport;
import org.example.dtosport.entity.dto.SportPersonDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class AppConfigurationData {

    @Bean("listSport")
    public List<Sport> listSport() {
        return List.of(
                new Sport("Soccer", 1),
                new Sport("Basket", 2),
                new Sport("Climb", 5),
                new Sport("Tennis", 3),
                new Sport("Golf", 2),
                new Sport("Boxing", 4),
                new Sport("Cricket", 3),
                new Sport("Skateboarding", 3)
        );
    }

    public List<Person> listPerson() {
        return List.of(
                new Person("Edwin", "Villarraga", 22),
                new Person("Camilo", "Gomez", 20),
                new Person("Diego", "Gonzalez", 32),
                new Person("Santiago", "Perez", 30),
                new Person("Danilo", "Arroyo", 19),
                new Person("Daniel", "Ardila", 28)
        );
    }

    @Bean
    public List<SportPersonDto> sportPerson() {
        Random r = new Random();
        List<Person> persons = listPerson();
        List<Sport> sports = listSport();
        int maxSport = sports.size();
        List<SportPersonDto> sportPersonDtos = new ArrayList<>();
        for (Person person : persons) {
            Sport current = sports.get(r.nextInt(maxSport));
            sportPersonDtos.add(
                    new SportPersonDto(person.getName(), person.getLastname(), current.getName())
            );
        }
        return sportPersonDtos;

    }
}
