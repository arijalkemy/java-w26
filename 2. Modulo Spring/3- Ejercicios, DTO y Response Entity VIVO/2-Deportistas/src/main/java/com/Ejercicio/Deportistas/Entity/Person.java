package com.Ejercicio.Deportistas.Entity;

import lombok.Data;
@Data
public class Person {
    private String name;
    private String surname;
    private Integer age;
    private Sport sport;

    public Person(String name, String surname, Integer age, Sport sport) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sport = sport;
    }
}
