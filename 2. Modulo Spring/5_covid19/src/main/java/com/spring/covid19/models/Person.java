package com.spring.covid19.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private String id;
    private String name;
    private String surname;
    private Integer age;

    public Person(String id, String name, String surname, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
