package com.example.demo.Athletes.Application.out;

import com.example.demo.Athletes.Domain.Person;

import java.util.List;

public interface IPersonFinds {
    List<Person> findAll();
    List<Person> findByName(String name);
    List<Person> findBySport(String sport);
}
