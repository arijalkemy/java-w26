package com.example.dto_y_response_entityp2.repository;

import com.example.dto_y_response_entityp2.entity.Person;

import java.util.List;

public interface IPersonRepository {
    List<Person> getAll();
}
