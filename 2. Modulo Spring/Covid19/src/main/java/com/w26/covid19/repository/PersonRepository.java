package com.w26.covid19.repository;

import com.w26.covid19.entity.Person;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

@Repository
@Data
public class PersonRepository {

    private List<Person> personList;

    public PersonRepository() {
        this.personList = new ArrayList<>();
        this.load();

    }

    public void load()
    {
        for (int i = 0; i < 50; i++) {
            int edad = new Random().nextInt(45, 65);
            Person person = new Person(String.valueOf(i), "Nombre"+i, "Apellido"+i, edad );
            this.personList.add(person);
            System.out.println(person);
        }
    }
}
