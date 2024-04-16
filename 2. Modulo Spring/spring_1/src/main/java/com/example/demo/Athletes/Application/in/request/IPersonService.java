package com.example.demo.Athletes.Application.in.request;

import com.example.demo.Athletes.Domain.Person;

import java.util.List;

public interface IPersonService {
    List<Person> findAll();
    Person findByName(String name);
    List<Person> findBySport(String sport);

}
