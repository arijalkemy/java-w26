package org.example.dto_p1_sports.repository.implementation;

import org.example.dto_p1_sports.entity.Person;
import org.example.dto_p1_sports.repository.interfaces.IPersonRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepositoryImp implements IPersonRepository {
    List<Person> personList = new ArrayList<>();

    public PersonRepositoryImp() {
        personList.add(new Person("Juan", "Sanchez", 23));
        personList.add(new Person("Armando", "Casas", 44));
        personList.add(new Person("Cris", "Leyva", 31));
        personList.add(new Person("Maria", "Lin", 20));
        personList.add(new Person("Carina", "Sem", 33));
        personList.add(new Person("Martin", "Soyus", 19));
    }

    @Override
    public List<Person> getAll() {
        return personList;
    }
}
