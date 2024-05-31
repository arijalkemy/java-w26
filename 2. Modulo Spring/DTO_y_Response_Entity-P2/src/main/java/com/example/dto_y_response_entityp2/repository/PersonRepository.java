package com.example.dto_y_response_entityp2.repository;

import com.example.dto_y_response_entityp2.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PersonRepository implements IPersonRepository{

    private List<Person> personList;

    public PersonRepository() {
        this.personList = new ArrayList<>();
        personList.add(new Person(1L,"Yair","Valderrama",28));
        personList.add(new Person(2L,"Marico","Baracus",60));
        personList.add(new Person(2L,"Isaac","Netero",110));
    }

    @Override
    public List<Person> getAll() {
        return personList;
    }
}
