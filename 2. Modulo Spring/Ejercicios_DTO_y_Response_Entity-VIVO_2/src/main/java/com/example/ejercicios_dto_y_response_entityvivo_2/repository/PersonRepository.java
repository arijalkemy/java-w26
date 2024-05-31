package com.example.ejercicios_dto_y_response_entityvivo_2.repository;

import com.example.ejercicios_dto_y_response_entityvivo_2.entity.Person;
import com.example.ejercicios_dto_y_response_entityvivo_2.entity.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    private  List<Person> personList;

    public PersonRepository() {
        this.personList = new ArrayList<>();
        personList.add(new Person("Karen","Gonzalez",15L));
        personList.add(new Person("Luz","Maria",28L));
        personList.add(new Person("Yair","Valderrama",27L));
    }

    public List<Person> getAll(){
        return personList;
    }
}
