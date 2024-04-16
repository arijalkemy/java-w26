package com.example.demo.Athletes.Application.in.request;

import com.example.demo.Athletes.Application.out.response.PersonSportResponse;
import com.example.demo.Athletes.Domain.Person;

import java.util.List;

public interface IPersonService {
    List<Person> findAll();
    List<Person> findByName(String name);
    List<PersonSportResponse> findBySport(String sport);

}
