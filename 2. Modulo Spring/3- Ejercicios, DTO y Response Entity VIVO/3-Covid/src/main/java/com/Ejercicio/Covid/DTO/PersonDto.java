package com.Ejercicio.Covid.DTO;

import com.Ejercicio.Covid.Entity.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDto implements Serializable {
    private String name;
    private String surname;
    private Integer age;


    @Autowired
    Person person;

    public PersonDto( String name, String surname, Integer age) {
        this.name = person.getName();
        this.surname = person.getSurname();
        this.age= person.getAge();
    }

}
