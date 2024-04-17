package com.spring.deportistas.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

}
