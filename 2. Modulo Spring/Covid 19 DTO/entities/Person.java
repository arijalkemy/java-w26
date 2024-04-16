package org.example.api.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private static Integer autoId = 0;
    private Integer id;
    private String name;
    private String lastname;
    private Integer age;

    public Person(String name, String lastname, Integer age) {
        this.id = ++Person.autoId;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }
}
