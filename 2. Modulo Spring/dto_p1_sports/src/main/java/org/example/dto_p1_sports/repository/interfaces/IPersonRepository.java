package org.example.dto_p1_sports.repository.interfaces;

import org.example.dto_p1_sports.entity.Person;

import java.util.List;

public interface IPersonRepository {
    List<Person> getAll();
}
