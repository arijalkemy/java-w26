package com.deportistas.deportistademo.repository.impl;

import com.deportistas.deportistademo.entity.Person;
import com.deportistas.deportistademo.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class IRepositoryPersonImpl implements IRepository<Person> {

    private static List<Person> personList = new ArrayList<>();


    @Override
    public List<Person> findAll() {
        return personList;
    }

    @Override
    public Optional<Person> find(String name) {
        return personList.stream()
                .filter(e->e.getName().equals(name))
                .findFirst();
    }

    @Override
    public void add(Person entity) {
        personList.add(entity);
    }


}
