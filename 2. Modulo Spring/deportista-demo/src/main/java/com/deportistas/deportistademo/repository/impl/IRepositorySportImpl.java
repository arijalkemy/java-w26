package com.deportistas.deportistademo.repository.impl;

import com.deportistas.deportistademo.entity.Sport;
import com.deportistas.deportistademo.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class IRepositorySportImpl implements IRepository<Sport>{

    private static List<Sport> sports = new ArrayList<>();

    @Override
    public List<Sport> findAll() {
        return sports;
    }

    @Override
    public Optional<Sport> find(String name) {
        return sports.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst();
    }

    @Override
    public void add(Sport entity) {
        sports.add(entity);
    }
}
